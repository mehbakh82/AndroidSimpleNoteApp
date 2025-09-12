package com.example.simplenote.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogOutConfirmationModal(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (isVisible) {
        // Custom overlay without Dialog - NO SHADOW POSSIBLE
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF180E25).copy(alpha = 0.4f))
                .clickable { onDismiss() }
        ) {
            // Modal Dialog - Exact CSS specifications - ABSOLUTELY NO SHADOW
            Box(
                modifier = Modifier
                    .width(280.dp) // 360px - 40px - 40px = 280dp
                    .height(230.dp)
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .clickable { } // Prevent click through
            ) {
                // Modal Content - Exact CSS specifications
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp, 32.dp), // 32px top/bottom, 24px left/right
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(48.dp)
                ) {
                    // Content - Exact CSS specifications
                    Column(
                        modifier = Modifier
                            .width(232.dp), // 280dp - 24dp - 24dp = 232dp
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        // Title & Description - Exact CSS specifications
                        Column(
                            modifier = Modifier
                                .width(232.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Title - Exact CSS specifications
                            Text(
                                text = "Log Out",
                                modifier = Modifier
                                    .width(232.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 28.sp,
                                textAlign = TextAlign.Center,
                                color = Color(0xFF180E25)
                            )
                            
                            // Description - Exact CSS specifications
                            Text(
                                text = "Are you sure you want to log out from the application?",
                                modifier = Modifier
                                    .width(232.dp),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 22.sp,
                                textAlign = TextAlign.Center,
                                color = Color(0xFF827D89)
                            )
                        }
                        
                        // Buttons - Exact CSS specifications
                        Row(
                            modifier = Modifier
                                .width(232.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Cancel Button - Custom implementation to avoid shadows
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFF504EC3),
                                        shape = RoundedCornerShape(100.dp)
                                    )
                                    .background(Color.White)
                                    .clickable { onDismiss() },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Cancel",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 22.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xFF504EC3)
                                )
                            }
                            
                            // Yes Button - Custom implementation to avoid shadows
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(38.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .background(Color(0xFF504EC3))
                                    .clickable { onConfirm() },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Yes",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 22.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
