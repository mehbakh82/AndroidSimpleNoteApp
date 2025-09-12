package com.example.simplenote.data.local.dao

import androidx.room.*
import com.example.simplenote.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserEntity?
    
    @Query("SELECT * FROM users WHERE is_current_user = 1 LIMIT 1")
    suspend fun getCurrentUser(): UserEntity?
    
    @Query("SELECT * FROM users WHERE is_current_user = 1 LIMIT 1")
    fun getCurrentUserFlow(): Flow<UserEntity?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)
    
    @Update
    suspend fun updateUser(user: UserEntity)
    
    @Query("UPDATE users SET is_synced = 1, last_updated = :timestamp WHERE id = :userId")
    suspend fun markUserAsSynced(userId: Int, timestamp: Long = System.currentTimeMillis())
    
    @Query("UPDATE users SET is_current_user = 0")
    suspend fun clearCurrentUser()
    
    @Query("UPDATE users SET is_current_user = 1 WHERE id = :userId")
    suspend fun setCurrentUser(userId: Int)
    
    @Query("DELETE FROM users")
    suspend fun clearAllUsers()
    
    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: Int)
}
