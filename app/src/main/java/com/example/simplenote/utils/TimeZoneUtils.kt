package com.example.simplenote.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeZoneUtils {
    
    // Timezone offset for +3:30 (Iran Standard Time)
    private const val TIMEZONE_OFFSET_HOURS = 3
    private const val TIMEZONE_OFFSET_MINUTES = 30
    
    /**
     * Converts a backend timestamp string to the local timezone (+3:30)
     * @param timestampString The timestamp string from backend (format: yyyy-MM-dd'T'HH:mm:ss)
     * @return Formatted time string in HH.mm format adjusted for +3:30 timezone
     */
    fun formatTimestampForDisplay(timestampString: String): String {
        return try {
            // Parse the backend timestamp (assuming it's in UTC)
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            val date = inputFormat.parse(timestampString)
            
            // Format for display with +3:30 timezone
            val outputFormat = SimpleDateFormat("HH.mm", Locale.getDefault())
            val timezone = TimeZone.getTimeZone("GMT+3:30") // +3:30 timezone
            outputFormat.timeZone = timezone
            
            outputFormat.format(date ?: Date())
        } catch (e: Exception) {
            "Unknown"
        }
    }
    
    /**
     * Converts a backend timestamp string to a full date and time string in local timezone
     * @param timestampString The timestamp string from backend
     * @return Formatted date and time string adjusted for +3:30 timezone
     */
    fun formatFullTimestampForDisplay(timestampString: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("UTC")
            val date = inputFormat.parse(timestampString)
            
            val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val timezone = TimeZone.getTimeZone("GMT+3:30")
            outputFormat.timeZone = timezone
            
            outputFormat.format(date ?: Date())
        } catch (e: Exception) {
            "Unknown"
        }
    }
    
    /**
     * Converts a Unix timestamp (milliseconds) to display format with +3:30 timezone
     * @param timestampMillis Unix timestamp in milliseconds
     * @return Formatted time string in HH.mm format
     */
    fun formatUnixTimestampForDisplay(timestampMillis: Long): String {
        return try {
            val outputFormat = SimpleDateFormat("HH.mm", Locale.getDefault())
            val timezone = TimeZone.getTimeZone("GMT+3:30")
            outputFormat.timeZone = timezone
            
            outputFormat.format(Date(timestampMillis))
        } catch (e: Exception) {
            "Unknown"
        }
    }
}
