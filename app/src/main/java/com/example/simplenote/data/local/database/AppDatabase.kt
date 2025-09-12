package com.example.simplenote.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.example.simplenote.data.local.dao.NoteDao
import com.example.simplenote.data.local.dao.UserDao
import com.example.simplenote.data.local.dao.UserCredentialsDao
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.data.local.entity.UserEntity
import com.example.simplenote.data.local.entity.UserCredentialsEntity

/**
 * Room database for local storage of notes and user data.
 * Provides offline-first functionality with automatic synchronization.
 * 
 * Entities:
 * - NoteEntity: Stores note data with sync status
 * - UserEntity: Stores user profile information
 */
@Database(
    entities = [NoteEntity::class, UserEntity::class, UserCredentialsEntity::class],
    version = 5,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun noteDao(): NoteDao
    abstract fun userDao(): UserDao
    abstract fun userCredentialsDao(): UserCredentialsDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "simple_note_database"
                )
                .fallbackToDestructiveMigration() // For development - in production, use proper migrations
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
