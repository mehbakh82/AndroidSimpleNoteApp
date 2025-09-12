package com.example.simplenote.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.simplenote.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    
    @Query("SELECT * FROM notes WHERE user_id = :userId ORDER BY updated_at DESC")
    fun getAllNotes(userId: Int): PagingSource<Int, NoteEntity>
    
    @Query("SELECT * FROM notes WHERE user_id = :userId AND (title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%') ORDER BY updated_at DESC")
    fun searchNotes(userId: Int, query: String): PagingSource<Int, NoteEntity>
    
    @Query("SELECT * FROM notes WHERE id = :noteId AND user_id = :userId")
    suspend fun getNoteById(noteId: Int, userId: Int): NoteEntity?
    
    @Query("SELECT * FROM notes WHERE user_id = :userId AND is_synced = 0")
    suspend fun getUnsyncedNotes(userId: Int): List<NoteEntity>
    
    @Query("SELECT * FROM notes WHERE user_id = :userId AND is_local_only = 1")
    suspend fun getLocalOnlyNotes(userId: Int): List<NoteEntity>
    
    @Query("SELECT * FROM notes WHERE user_id = :userId ORDER BY updated_at DESC LIMIT :limit OFFSET :offset")
    suspend fun getAllNotesPaged(userId: Int, offset: Int, limit: Int): List<NoteEntity>
    
    @Query("SELECT * FROM notes WHERE user_id = :userId AND (title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%') ORDER BY updated_at DESC LIMIT :limit OFFSET :offset")
    suspend fun searchNotesPaged(userId: Int, query: String, offset: Int, limit: Int): List<NoteEntity>
    
    @Query("SELECT * FROM notes WHERE user_id = :userId AND is_modified = 1")
    suspend fun getModifiedNotes(userId: Int): List<NoteEntity>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>)
    
    @Update
    suspend fun updateNote(note: NoteEntity)
    
    @Delete
    suspend fun deleteNote(note: NoteEntity)
    
    @Query("DELETE FROM notes WHERE id = :noteId AND user_id = :userId")
    suspend fun deleteNoteById(noteId: Int, userId: Int)
    
    @Query("UPDATE notes SET is_synced = 1, is_modified = 0 WHERE id = :noteId AND user_id = :userId")
    suspend fun markNoteAsSynced(noteId: Int, userId: Int)
    
    @Query("UPDATE notes SET id = :newId, is_synced = 1, is_local_only = 0, creator_name = :creatorName, creator_username = :creatorUsername WHERE id = :oldId AND user_id = :userId")
    suspend fun updateLocalNoteWithServerData(oldId: Int, newId: Int, userId: Int, creatorName: String, creatorUsername: String)
    
    @Query("UPDATE notes SET is_modified = 1, last_modified_local = :timestamp WHERE id = :noteId AND user_id = :userId")
    suspend fun markNoteAsModified(noteId: Int, userId: Int, timestamp: Long = System.currentTimeMillis())
    
    @Query("DELETE FROM notes WHERE user_id = :userId")
    suspend fun clearUserNotes(userId: Int)
    
    @Query("DELETE FROM notes")
    suspend fun clearAllNotes()
    
    @Query("SELECT COUNT(*) FROM notes WHERE user_id = :userId")
    suspend fun getNoteCount(userId: Int): Int
    
    @Query("SELECT COUNT(*) FROM notes WHERE user_id = :userId AND is_synced = 0")
    suspend fun getUnsyncedCount(userId: Int): Int
}
