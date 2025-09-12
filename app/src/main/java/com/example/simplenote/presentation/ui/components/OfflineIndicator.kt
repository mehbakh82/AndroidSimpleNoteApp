package com.example.simplenote.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.data.sync.SyncManager
import com.example.simplenote.utils.TimeZoneUtils

@Composable
fun OfflineIndicator(
    syncManager: SyncManager,
    modifier: Modifier = Modifier
) {
    var isOnline by remember { mutableStateOf(true) }
    var isSyncing by remember { mutableStateOf(false) }
    var lastSyncTime by remember { mutableStateOf<Long?>(null) }
    
    LaunchedEffect(Unit) {
        syncManager.isOnline.collect { isOnline = it }
    }
    
    LaunchedEffect(Unit) {
        syncManager.isSyncing.collect { isSyncing = it }
    }
    
    LaunchedEffect(Unit) {
        syncManager.lastSyncTime.collect { lastSyncTime = it }
    }
    
    if (!isOnline) {
        // Offline indicator
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFFF6B6B))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Offline",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "You're offline. Changes will sync when you're back online.",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    } else if (isSyncing) {
        // Syncing indicator
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFF4CAF50))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
            Text(
                text = "Syncing...",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    } else if (lastSyncTime != null) {
        // Last sync time indicator (optional - can be removed if not needed)
        val syncTimeText = try {
            val time = TimeZoneUtils.formatUnixTimestampForDisplay(lastSyncTime ?: 0L)
            "Last synced at $time"
        } catch (e: Exception) {
            "Synced"
        }
        
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E8))
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Synced",
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = syncTimeText,
                color = Color(0xFF2E7D32),
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
