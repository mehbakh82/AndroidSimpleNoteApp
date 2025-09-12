package com.example.simplenote.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.MessageDigest

/**
 * Entity for storing user credentials securely for offline authentication.
 * Passwords are hashed using SHA-256 before storage.
 */
@Entity(tableName = "user_credentials")
data class UserCredentialsEntity(
    @PrimaryKey
    val username: String,
    val hashedPassword: String,
    val created_at: Long = System.currentTimeMillis(),
    val last_used: Long = System.currentTimeMillis()
) {
    companion object {
        fun create(username: String, password: String): UserCredentialsEntity {
            return UserCredentialsEntity(
                username = username,
                hashedPassword = hashPassword(password)
            )
        }
        
        private fun hashPassword(password: String): String {
            val digest = MessageDigest.getInstance("SHA-256")
            val hash = digest.digest(password.toByteArray())
            return hash.joinToString("") { "%02x".format(it) }
        }
        
        fun verifyPassword(password: String, hashedPassword: String): Boolean {
            return hashPassword(password) == hashedPassword
        }
    }
}
