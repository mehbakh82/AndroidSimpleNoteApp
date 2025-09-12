package com.example.simplenote.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.simplenote.data.local.LocalNotePagingSource
import com.example.simplenote.data.local.dao.NoteDao
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalNoteRepository(
    private val noteDao: NoteDao
) {
    
    private var currentUserId: Int? = null
    
    fun setCurrentUser(userId: Int) {
        currentUserId = userId
    }
    
    fun getCurrentUserId(): Int? = currentUserId
    
    fun getNotesPager(query: String): Pager<Int, Note> {
        val userId = currentUserId ?: throw IllegalStateException("No current user set")
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                LocalNotePagingSource(noteDao, query, userId)
            }
        )
    }
    
    suspend fun getNoteById(noteId: Int): Note? {
        val userId = currentUserId ?: return null
        return noteDao.getNoteById(noteId, userId)?.toNote()
    }
    
    suspend fun insertNote(note: Note, isSynced: Boolean = true): Long {
        val userId = currentUserId ?: throw IllegalStateException("No current user set")
        val isLocalOnly = !isSynced && note.id == 0 // If not synced and has temp ID, it's local only
        val noteEntity = NoteEntity.fromNote(note, userId, isSynced = isSynced, isModified = !isSynced, isLocalOnly = isLocalOnly)
        return noteDao.insertNote(noteEntity)
    }
    
    suspend fun insertNotes(notes: List<Note>, isSynced: Boolean = true) {
        val userId = currentUserId ?: throw IllegalStateException("No current user set")
        val noteEntities = notes.map { NoteEntity.fromNote(it, userId, isSynced = isSynced) }
        noteDao.insertNotes(noteEntities)
    }
    
    suspend fun updateNote(note: Note, isSynced: Boolean = true) {
        val userId = currentUserId ?: throw IllegalStateException("No current user set")
        val noteEntity = NoteEntity.fromNote(note, userId, isSynced = isSynced, isModified = !isSynced)
        noteDao.updateNote(noteEntity)
    }
    
    suspend fun updateNoteLocal(noteId: Int, title: String, description: String) {
        val userId = currentUserId ?: return
        val existingNote = noteDao.getNoteById(noteId, userId)
        if (existingNote != null) {
            val updatedNote = existingNote.copy(
                title = title,
                description = description,
                is_synced = false,
                is_modified = true,
                last_modified_local = System.currentTimeMillis()
            )
            noteDao.updateNote(updatedNote)
        }
    }
    
    suspend fun deleteNote(noteId: Int) {
        val userId = currentUserId ?: return
        noteDao.deleteNoteById(noteId, userId)
    }
    
    suspend fun getUnsyncedNotes(): List<Note> {
        val userId = currentUserId ?: return emptyList()
        return noteDao.getUnsyncedNotes(userId).map { it.toNote() }
    }
    
    suspend fun getLocalOnlyNotes(): List<Note> {
        val userId = currentUserId ?: return emptyList()
        return noteDao.getLocalOnlyNotes(userId).map { it.toNote() }
    }
    
    suspend fun getModifiedNotes(): List<Note> {
        val userId = currentUserId ?: return emptyList()
        return noteDao.getModifiedNotes(userId).map { it.toNote() }
    }
    
    suspend fun markNoteAsSynced(noteId: Int) {
        val userId = currentUserId ?: return
        noteDao.markNoteAsSynced(noteId, userId)
    }
    
    suspend fun updateLocalNoteWithServerData(oldId: Int, newId: Int, creatorName: String, creatorUsername: String) {
        val userId = currentUserId ?: return
        noteDao.updateLocalNoteWithServerData(oldId, newId, userId, creatorName, creatorUsername)
    }
    
    suspend fun markNoteAsModified(noteId: Int) {
        val userId = currentUserId ?: return
        noteDao.markNoteAsModified(noteId, userId)
    }
    
    suspend fun clearAllNotes() {
        noteDao.clearAllNotes()
    }
    
    suspend fun clearUserNotes() {
        val userId = currentUserId ?: return
        noteDao.clearUserNotes(userId)
    }
    
    suspend fun getNoteCount(): Int {
        val userId = currentUserId ?: return 0
        return noteDao.getNoteCount(userId)
    }
    
    suspend fun getUnsyncedCount(): Int {
        val userId = currentUserId ?: return 0
        return noteDao.getUnsyncedCount(userId)
    }
    
    suspend fun getNotesPaged(query: String, page: Int, pageSize: Int): List<Note> {
        val userId = currentUserId ?: return emptyList()
        val offset = page * pageSize
        val notes = if (query.isBlank()) {
            noteDao.getAllNotesPaged(userId, offset, pageSize)
        } else {
            noteDao.searchNotesPaged(userId, query, offset, pageSize)
        }
        return notes.map { it.toNote() }
    }
}
