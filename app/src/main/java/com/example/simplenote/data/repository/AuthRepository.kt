package com.example.simplenote.data.repository

import com.example.simplenote.data.remote.AuthService
import com.example.simplenote.data.sync.SyncManager
import com.example.simplenote.domain.model.LoginRequest
import com.example.simplenote.domain.model.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import com.example.simplenote.data.local.TokenManager
import com.example.simplenote.domain.model.ChangePasswordRequest
import kotlinx.coroutines.flow.first

class AuthRepository(
    private val api: AuthService,
    private val tokenManager: TokenManager,
    private val localUserRepository: LocalUserRepository? = null,
    private val syncManager: SyncManager? = null
) {
    suspend fun login(username: String, password: String): String? = withContext(Dispatchers.IO) {
        try {
            // First try online login
            val response = api.login(LoginRequest(username, password))
            tokenManager.saveAccessToken(response.access)
            tokenManager.saveRefreshToken(response.refresh)
            
            // Store credentials locally for offline login
            localUserRepository?.saveUserCredentials(username, password)
            
            response.access
        } catch (e: Exception) {
            // If online login fails, try offline login
            try {
                val isValidCredentials = localUserRepository?.validateCredentials(username, password) ?: false
                if (isValidCredentials) {
                    // Check if we have a valid stored token
                    val storedToken = tokenManager.getAccessToken()
                    if (storedToken != null) {
                        // Use stored token for offline access
                        return@withContext storedToken
                    }
                }
                null
            } catch (offlineException: Exception) {
                null
            }
        }
    }

    suspend fun register(
        firstName: String,
        lastName: String,
        username: String,
        email: String,
        password: String
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            val response = api.register(
                RegisterRequest(
                    username = username,
                    password = password,
                    email = email,
                    first_name = firstName,
                    last_name = lastName
                )
            )
            // Registration response handled
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    suspend fun changePassword(oldPassword: String, newPassword: String): Result<Unit> {
        return try {
            val response = api.changePassword(ChangePasswordRequest(oldPassword, newPassword))
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Change password failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // ADDED THIS FUNCTION
    suspend fun logout() = withContext(Dispatchers.IO) {
        tokenManager.clearTokens()
        // Clear current user flag and local user data on logout
        localUserRepository?.clearCurrentUser()
        localUserRepository?.clearAllUsers()
        localUserRepository?.clearAllCredentials()
    }
    
    // Get user info with offline support
    suspend fun getUserInfo() = withContext(Dispatchers.IO) {
        try {
            // Always try server first if we have network connectivity
            try {
                val userInfo = api.getUserInfo()
                // Save to local database if available and set as current user
                localUserRepository?.insertUser(userInfo, isCurrentUser = true)
                localUserRepository?.setCurrentUser(userInfo.id)
                syncManager?.updateLastSyncTime()
                userInfo
            } catch (e: Exception) {
                // If server fails, try local storage
                val localUser = localUserRepository?.getCurrentUser()
                if (localUser != null) {
                    localUser
                } else {
                    throw e
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }
    
    // Set current user context for data isolation
    suspend fun setCurrentUserContext() = withContext(Dispatchers.IO) {
        val userInfo = getUserInfo()
        // This will be used by NoteRepository to set user context
        userInfo
    }
}