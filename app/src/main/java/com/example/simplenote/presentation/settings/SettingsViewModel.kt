package com.example.simplenote.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.data.repository.AuthRepository
import com.example.simplenote.data.repository.SettingsRepository
import com.example.simplenote.domain.model.UserInfoResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsRepository: SettingsRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _userInfo = MutableStateFlow<UserInfoResponse?>(null)
    val userInfo: StateFlow<UserInfoResponse?> = _userInfo

    // The SharedFlow for logout events has been removed.

    fun fetchUserInfo() {
        viewModelScope.launch {
            try {
                val userInfo = settingsRepository.getUserInfo()
                _userInfo.value = userInfo
            } catch (e: Exception) {
                // Try to get user info directly from AuthRepository as fallback
                try {
                    val directUserInfo = authRepository.getUserInfo()
                    _userInfo.value = directUserInfo
                } catch (e2: Exception) {
                    // If both fail, show a placeholder or error state
                    _userInfo.value = UserInfoResponse(
                        id = 0,
                        username = "Unknown",
                        email = "unknown@example.com",
                        first_name = "Loading",
                        last_name = "..."
                    )
                }
            }
        }
    }

    // This function is now simpler. It just calls the repository.
    // The navigation will happen automatically when the token state changes.
    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }
}