package com.example.simplenote.data.sync

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Manages network connectivity and synchronization state.
 * Monitors network availability and provides sync status information.
 * 
 * @param context Android context for accessing system services
 */
class SyncManager(private val context: Context) {
    
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    
    private val _isOnline = MutableStateFlow(isNetworkAvailable())
    val isOnline: StateFlow<Boolean> = _isOnline.asStateFlow()
    
    private val _isSyncing = MutableStateFlow(false)
    val isSyncing: StateFlow<Boolean> = _isSyncing.asStateFlow()
    
    private val _lastSyncTime = MutableStateFlow<Long?>(null)
    val lastSyncTime: StateFlow<Long?> = _lastSyncTime.asStateFlow()
    
    init {
        try {
            setupNetworkCallback()
        } catch (e: Exception) {
            // Fallback to basic network check if callback setup fails
            _isOnline.value = isNetworkAvailable()
        }
    }
    
    private fun setupNetworkCallback() {
        try {
            val networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()
                
            connectivityManager.registerNetworkCallback(networkRequest, object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    _isOnline.value = true
                }
                
                override fun onLost(network: Network) {
                    _isOnline.value = isNetworkAvailable()
                }
            })
        } catch (e: Exception) {
            // If network callback fails, just use basic network check
            _isOnline.value = isNetworkAvailable()
        }
    }
    
    private fun isNetworkAvailable(): Boolean {
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
               capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
    
    fun setSyncing(syncing: Boolean) {
        _isSyncing.value = syncing
    }
    
    fun updateLastSyncTime() {
        _lastSyncTime.value = System.currentTimeMillis()
    }
    
    fun isNetworkAvailableNow(): Boolean {
        return isNetworkAvailable()
    }
}
