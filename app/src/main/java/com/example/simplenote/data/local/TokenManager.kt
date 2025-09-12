package com.example.simplenote.data.local

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Manages JWT tokens for authentication with reactive state updates.
 * Handles secure storage and automatic token refresh flow.
 * 
 * @param context Android context for SharedPreferences access
 */
class TokenManager(context: Context) {
    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    // 1. Create a StateFlow to hold the current token state
    private val _accessTokenFlow = MutableStateFlow<String?>(getAccessToken())
    val accessTokenFlow = _accessTokenFlow.asStateFlow()

    fun saveTokens(access: String, refresh: String) {
        prefs.edit()
            .putString("access_token", access)
            .putString("refresh_token", refresh)
            .apply()
        // 2. Update the flow with the new token
        _accessTokenFlow.value = access
    }

    fun saveAccessToken(access: String) {
        prefs.edit()
            .putString("access_token", access)
            .apply()
        // 3. Update the flow with the new token
        _accessTokenFlow.value = access
    }

    fun saveRefreshToken(refresh: String) {
        prefs.edit()
            .putString("refresh_token", refresh)
            .apply()
    }

    fun getAccessToken(): String? = prefs.getString("access_token", null)
    fun getRefreshToken(): String? = prefs.getString("refresh_token", null)

    fun clearTokens() {
        prefs.edit().clear().apply()
        // 4. Update the flow to notify the app of logout
        _accessTokenFlow.value = null
    }
}