package com.example.simplenote.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simplenote.domain.model.Note

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val created_at: String,
    val updated_at: String,
    val creator_name: String,
    val creator_username: String,
    val user_id: Int, // Associate note with specific user
    val is_synced: Boolean = true, // Track if this note is synced with server
    val is_modified: Boolean = false, // Track if this note has local modifications
    val last_modified_local: Long = System.currentTimeMillis(), // Local timestamp for conflict resolution
    val is_local_only: Boolean = false // Track if this note was created locally and never synced
) {
    fun toNote(): Note {
        return Note(
            id = id,
            title = title,
            description = description,
            created_at = created_at,
            updated_at = updated_at,
            creator_name = creator_name,
            creator_username = creator_username
        )
    }
    
    companion object {
        fun fromNote(note: Note, userId: Int, isSynced: Boolean = true, isModified: Boolean = false, isLocalOnly: Boolean = false): NoteEntity {
            return NoteEntity(
                id = note.id,
                title = note.title,
                description = note.description,
                created_at = note.created_at,
                updated_at = note.updated_at,
                creator_name = note.creator_name,
                creator_username = note.creator_username,
                user_id = userId,
                is_synced = isSynced,
                is_modified = isModified,
                last_modified_local = System.currentTimeMillis(),
                is_local_only = isLocalOnly
            )
        }
    }
}
