package com.example.simplenote.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.data.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChangePasswordViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    fun changePassword(oldPassword: String, newPassword: String) {
        viewModelScope.launch {
            try {
                val response = settingsRepository.changePassword(oldPassword, newPassword)
                _message.value = when {
                    response.isSuccessful -> "Password changed successfully"
                    response.code() == 400 -> {
                        // Handle validation errors
                        val errorBody = response.errorBody()?.string() ?: ""
                        if (errorBody.contains("old_password")) {
                            "Current password is incorrect"
                        } else if (errorBody.contains("new_password")) {
                            "New password does not meet requirements"
                        } else {
                            "Invalid request. Please check your input."
                        }
                    }
                    response.code() == 401 -> "Authentication failed. Please login again."
                    response.code() == 500 -> "Server error. Please try again later."
                    else -> "Failed to change password. Please try again."
                }
            } catch (e: Exception) {
                _message.value = "Network error: ${e.message}"
            }
        }
    }
    
    fun clearMessage() {
        _message.value = ""
    }
}
