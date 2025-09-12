package com.example.simplenote.data.remote

import com.example.simplenote.data.local.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(
    private val tokenManager: TokenManager,
    private val authService: AuthService
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val refreshToken = tokenManager.getRefreshToken() ?: return null

        return runBlocking {
            try {
                val tokenResponse = authService.refreshToken(mapOf("refresh" to refreshToken))
                val newAccessToken = tokenResponse.access

                // If logout happened during refresh (refresh token cleared), skip saving
                if (tokenManager.getRefreshToken() == null) {
                    return@runBlocking null
                }

                tokenManager.saveAccessToken(newAccessToken)

                response.request.newBuilder()
                    .header("Authorization", "Bearer $newAccessToken")
                    .build()
            } catch (e: Exception) {
                null
            }
        }
    }
}
