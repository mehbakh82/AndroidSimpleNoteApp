package com.example.simplenote.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simplenote.domain.model.UserInfoResponse

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val username: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val is_synced: Boolean = true,
    val last_updated: Long = System.currentTimeMillis(),
    val is_current_user: Boolean = false // Track which user is currently active
) {
    fun toUserInfo(): UserInfoResponse {
        return UserInfoResponse(
            id = id,
            username = username,
            email = email,
            first_name = first_name,
            last_name = last_name
        )
    }
    
    companion object {
        fun fromUserInfo(userInfo: UserInfoResponse, isCurrentUser: Boolean = false): UserEntity {
            return UserEntity(
                id = userInfo.id,
                username = userInfo.username,
                email = userInfo.email,
                first_name = userInfo.first_name,
                last_name = userInfo.last_name,
                is_synced = true,
                last_updated = System.currentTimeMillis(),
                is_current_user = isCurrentUser
            )
        }
    }
}
