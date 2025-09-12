package com.example.simplenote.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.simplenote.data.remote.NoteApi
import com.example.simplenote.data.sync.SyncManager
import com.example.simplenote.domain.model.Note
import com.example.simplenote.domain.model.NoteRequest
import com.example.simplenote.domain.model.UpdateNoteRequest
import com.example.simplenote.presentation.home.NotePagingSource
import kotlinx.coroutines.flow.first

/**
 * Repository for managing notes with offline-first approach.
 * Handles both local and remote data sources with automatic synchronization.
 * 
 * @param api Remote API service for server communication
 * @param localRepository Local database repository for offline storage
 * @param syncManager Sync manager for handling network state and synchronization
 */
class NoteRepository(
    private val api: NoteApi,
    private val localRepository: LocalNoteRepository? = null,
    private val syncManager: SyncManager? = null
) {
    
    // Set current user context for data isolation
    fun setCurrentUser(userId: Int) {
        localRepository?.setCurrentUser(userId)
    }
    
    /**
     * Adds a new note with offline-first approach.
     * Tries to create on server first, falls back to local storage if offline.
     * 
     * @param note The note request containing title and description
     * @return The created note with server-assigned ID
     */
    suspend fun addNote(note: NoteRequest): Note {
        return try {
            // Try to create on server first
            val createdNote = api.createNote(note)
            // Save to local database if available
            localRepository?.insertNote(createdNote, isSynced = true)
            syncManager?.updateLastSyncTime()
            createdNote
        } catch (e: Exception) {
            // If server fails, save locally if available
            if (localRepository != null) {
                val localNote = Note(
                    id = 0, // Temporary ID - will be replaced by auto-generated ID
                    title = note.title,
                    description = note.description,
                    created_at = java.time.Instant.now().toString(),
                    updated_at = java.time.Instant.now().toString(),
                    creator_name = "", // Will be updated when synced
                    creator_username = ""
                )
                val insertedId = localRepository.insertNote(localNote, isSynced = false)
                // Return the note with the auto-generated ID
                localNote.copy(id = insertedId.toInt())
            } else {
                // If no local storage, rethrow the error
                throw e
            }
        }
    }
    /**
     * Deletes a note by ID with offline support.
     * Tries to delete from server first, removes locally if offline.
     * 
     * @param noteId The ID of the note to delete
     */
    suspend fun deleteNote(noteId: Int) {
        try {
            // Try to delete from server first
            api.deleteNote(noteId)
            // Remove from local database if available
            localRepository?.deleteNote(noteId)
            syncManager?.updateLastSyncTime()
        } catch (e: Exception) {
            // If server fails, just delete locally if available
            localRepository?.deleteNote(noteId)
        }
    }
    /**
     * Retrieves a note by ID with offline-first approach.
     * Checks local storage first for better performance, then server if needed.
     * 
     * @param noteId The ID of the note to retrieve
     * @return The note if found, null otherwise
     */
    suspend fun getNoteById(noteId: Int): Note? {
        // Try local first for better performance
        localRepository?.getNoteById(noteId)?.let { return it }
        
        // If not found locally, try server
        return try {
            val serverNote = api.getNoteById(noteId)
            // Save to local database if available
            localRepository?.insertNote(serverNote, isSynced = true)
            serverNote
        } catch (e: Exception) {
            null
        }
    }
    fun getNotesPager(query: String): Pager<Int, Note> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = { NotePagingSource(api, query) }
        )
    }

    suspend fun updateNote(id: Int, title: String, description: String) {
        try {
            // Try to update on server first
            api.updateNote(id, UpdateNoteRequest(title, description))
            // Get the updated note from server to get the new timestamp
            val updatedNote = api.getNoteById(id)
            // Update local database with the complete updated note
            localRepository?.insertNote(updatedNote, isSynced = true)
            syncManager?.updateLastSyncTime()
        } catch (e: Exception) {
            // If server fails, update locally if available
            localRepository?.updateNoteLocal(id, title, description)
        }
    }
    
    // Background sync method
    suspend fun syncNotes() {
        if (localRepository == null || syncManager == null) return
        
        try {
            syncManager.setSyncing(true)
            
            // Get local-only notes (created offline)
            val localOnlyNotes = localRepository.getLocalOnlyNotes()
            
            for (note in localOnlyNotes) {
                try {
                    // Create on server
                    val noteRequest = NoteRequest(note.title, note.description)
                    val createdNote = api.createNote(noteRequest)
                    // Update the local note with server data
                    localRepository.updateLocalNoteWithServerData(
                        note.id, 
                        createdNote.id, 
                        createdNote.creator_name, 
                        createdNote.creator_username
                    )
                } catch (e: Exception) {
                    // Continue with other notes if one fails
                    continue
                }
            }
            
            // Get other unsynced notes (modified existing notes)
            val unsyncedNotes = localRepository.getUnsyncedNotes()
            
            for (note in unsyncedNotes) {
                try {
                    // Existing note - update on server
                    api.updateNote(note.id, UpdateNoteRequest(note.title, note.description))
                    localRepository.markNoteAsSynced(note.id)
                } catch (e: Exception) {
                    // Continue with other notes if one fails
                    continue
                }
            }
            
            syncManager.updateLastSyncTime()
        } finally {
            syncManager.setSyncing(false)
        }
    }
    
    // Get count of unsynced notes
    suspend fun getUnsyncedCount(): Int {
        return localRepository?.getUnsyncedCount() ?: 0
    }
    
    // Get notes from local database with pagination
    suspend fun getLocalNotesPaged(query: String, page: Int, pageSize: Int): List<Note> {
        return localRepository?.getNotesPaged(query, page, pageSize) ?: emptyList()
    }
    
    // Get notes from remote API with pagination
    suspend fun getRemoteNotesPaged(query: String, page: Int, pageSize: Int): List<Note> {
        return try {
            val response = if (query.isBlank()) {
                api.getNotes(page = page, pageSize = pageSize)
            } else {
                api.filterNotes(
                    title = query,
                    description = query,
                    updatedGte = null,
                    updatedLte = null,
                    page = page,
                    pageSize = pageSize
                )
            }
            response.results
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    // Save notes to local database
    suspend fun saveNotesToLocal(notes: List<Note>) {
        localRepository?.insertNotes(notes, isSynced = true)
    }
}