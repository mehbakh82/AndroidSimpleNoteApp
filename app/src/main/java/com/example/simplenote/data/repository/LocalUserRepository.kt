package com.example.simplenote.data.repository

import com.example.simplenote.data.local.dao.UserDao
import com.example.simplenote.data.local.dao.UserCredentialsDao
import com.example.simplenote.data.local.entity.UserEntity
import com.example.simplenote.data.local.entity.UserCredentialsEntity
import com.example.simplenote.domain.model.UserInfoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserRepository(
    private val userDao: UserDao,
    private val userCredentialsDao: UserCredentialsDao
) {
    
    suspend fun getCurrentUser(): UserInfoResponse? {
        return userDao.getCurrentUser()?.toUserInfo()
    }
    
    fun getCurrentUserFlow(): Flow<UserInfoResponse?> {
        return userDao.getCurrentUserFlow().map { it?.toUserInfo() }
    }
    
    suspend fun insertUser(userInfo: UserInfoResponse, isCurrentUser: Boolean = false) {
        val userEntity = UserEntity.fromUserInfo(userInfo, isCurrentUser)
        userDao.insertUser(userEntity)
    }
    
    suspend fun setCurrentUser(userId: Int) {
        // Clear all current user flags first
        userDao.clearCurrentUser()
        // Set the specified user as current
        userDao.setCurrentUser(userId)
    }
    
    suspend fun clearCurrentUser() {
        userDao.clearCurrentUser()
    }
    
    suspend fun updateUser(userInfo: UserInfoResponse) {
        val userEntity = UserEntity.fromUserInfo(userInfo)
        userDao.updateUser(userEntity)
    }
    
    suspend fun markUserAsSynced(userId: Int) {
        userDao.markUserAsSynced(userId)
    }
    
    suspend fun clearAllUsers() {
        userDao.clearAllUsers()
    }
    
    suspend fun deleteUser(userId: Int) {
        userDao.deleteUser(userId)
    }
    
    // Credential management methods
    suspend fun saveUserCredentials(username: String, password: String) {
        val credentials = UserCredentialsEntity.create(username, password)
        userCredentialsDao.insertCredentials(credentials)
    }
    
    suspend fun validateCredentials(username: String, password: String): Boolean {
        val credentials = userCredentialsDao.getCredentialsByUsername(username) ?: return false
        val isValid = UserCredentialsEntity.verifyPassword(password, credentials.hashedPassword)
        
        if (isValid) {
            // Update last used timestamp
            userCredentialsDao.updateLastUsed(username)
        }
        
        return isValid
    }
    
    suspend fun clearAllCredentials() {
        userCredentialsDao.clearAllCredentials()
    }
    
    suspend fun deleteCredentials(username: String) {
        userCredentialsDao.deleteCredentials(username)
    }
}
