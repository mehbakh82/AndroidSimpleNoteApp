package com.example.simplenote.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: com.example.simplenote.presentation.settings.SettingsViewModel
) {
    var showLogoutModal by remember { mutableStateOf(false) }
    val userInfo by viewModel.userInfo.collectAsState()
    
    // Fetch user info when screen loads
    LaunchedEffect(Unit) {
        viewModel.fetchUserInfo()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar spacer
            Spacer(modifier = Modifier.height(42.dp))
            
            // Nav Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .background(Color.White)
            ) {
                // Back button - positioned on the left
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable { onBackClick() }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF504EC3),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Back",
                        color = Color(0xFF504EC3),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 22.sp
                    )
                }
                
                // Title - centered
                Text(
                    text = "Settings",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            
            // Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Profile Section
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    // Profile Picture, Full Name & Email Address
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Profile Picture
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE0E0E0)), // Placeholder background
                            contentAlignment = Alignment.Center
                        ) {
                            // Placeholder for profile image
                            // You can replace this with actual profile image
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Profile",
                                tint = Color(0xFF827D89),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        
                        // Full Name & Email Address
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .height(51.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Full Name
                            Text(
                                text = userInfo?.let { "${it.first_name} ${it.last_name}" } ?: "Loading...",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 28.sp,
                                color = Color(0xFF180E25)
                            )
                            
                            // Email Address & Icon
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Email Icon
                                Icon(
                                    imageVector = Icons.Filled.Email,
                                    contentDescription = "Email",
                                    tint = Color(0xFF827D89),
                                    modifier = Modifier.size(15.dp)
                                )
                                
                                // Email Address
                                Text(
                                    text = userInfo?.email ?: "Loading...",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                    lineHeight = 15.sp,
                                    color = Color(0xFF827D89)
                                )
                            }
                        }
                    }
                    
                    // Divider
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFEFEEF0),
                        thickness = 1.dp
                    )
                }
                
                // App Settings
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Label
                    Text(
                        text = "APP SETTINGS",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 12.sp,
                        color = Color(0xFF827D89)
                    )
                    
                    // Menus
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Change Password Menu Item
                        SettingsMenuItem(
                            icon = Icons.Filled.Lock,
                            title = "Change Password",
                            iconColor = Color(0xFF180E25),
                            textColor = Color(0xFF180E25),
                            onClick = onChangePasswordClick
                        )
                        
                        // Divider
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color(0xFFEFEEF0),
                            thickness = 1.dp
                        )
                        
                        // Log Out Menu Item
                        SettingsMenuItem(
                            icon = Icons.AutoMirrored.Filled.ExitToApp,
                            title = "Log Out",
                            iconColor = Color(0xFFCE3A54),
                            textColor = Color(0xFFCE3A54),
                            onClick = { showLogoutModal = true }
                        )
                    }
                }
            }
        }
        
        // App Version - Bottom Center
        Text(
            text = "Taha Notes v1.1",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 15.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFC8C5CB)
        )
        
        // Log Out Confirmation Modal
        LogOutConfirmationModal(
            isVisible = showLogoutModal,
            onDismiss = { showLogoutModal = false },
            onConfirm = {
                showLogoutModal = false
                onLogoutClick()
            }
        )
    }
}

@Composable
private fun SettingsMenuItem(
    icon: ImageVector,
    title: String,
    iconColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                Color.White,
                RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Icon
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
        
        // Title
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = textColor
        )
        
        // Chevron Right Icon
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Navigate",
            tint = Color(0xFF827D89),
            modifier = Modifier.size(16.dp)
        )
    }
}