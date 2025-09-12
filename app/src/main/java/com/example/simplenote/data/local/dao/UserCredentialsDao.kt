package com.example.simplenote.data.local.dao

import androidx.room.*
import com.example.simplenote.data.local.entity.UserCredentialsEntity

@Dao
interface UserCredentialsDao {
    
    @Query("SELECT * FROM user_credentials WHERE username = :username")
    suspend fun getCredentialsByUsername(username: String): UserCredentialsEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCredentials(credentials: UserCredentialsEntity)
    
    @Update
    suspend fun updateCredentials(credentials: UserCredentialsEntity)
    
    @Query("UPDATE user_credentials SET last_used = :timestamp WHERE username = :username")
    suspend fun updateLastUsed(username: String, timestamp: Long = System.currentTimeMillis())
    
    @Query("DELETE FROM user_credentials")
    suspend fun clearAllCredentials()
    
    @Query("DELETE FROM user_credentials WHERE username = :username")
    suspend fun deleteCredentials(username: String)
}
