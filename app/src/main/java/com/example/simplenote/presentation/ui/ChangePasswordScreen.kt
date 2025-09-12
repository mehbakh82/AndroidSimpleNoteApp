package com.example.simplenote.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.presentation.auth.ChangePasswordViewModel

@Composable
fun ChangePasswordScreen(
    onBack: () -> Unit,
    viewModel: ChangePasswordViewModel
) {
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var retypePassword by remember { mutableStateOf("") }
    
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    
    // Collect the message from ViewModel
    val message by viewModel.message.collectAsState()
    
    // Handle success message
    LaunchedEffect(message) {
        if (message.contains("successfully", ignoreCase = true)) {
            isLoading = false
            onBack() // Navigate back on success
        } else if (message.isNotEmpty() && !message.contains("successfully", ignoreCase = true)) {
            isLoading = false
            errorMessage = message
        }
    }
    
    // Clear error message when user starts typing
    LaunchedEffect(currentPassword, newPassword, retypePassword) {
        if (errorMessage.isNotEmpty()) {
            errorMessage = ""
            viewModel.clearMessage()
        }
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            // Nav Bar (white with bottom divider) respecting status bar insets
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .height(54.dp)
                    .background(Color.White)
            ) {
                HorizontalDivider(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    color = Color(0xFFEFEEF0),
                    thickness = 1.dp
                )
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                        .clickable { onBack() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF504EC3)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Back",
                        color = Color(0xFF504EC3),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Text(
                    text = "Change Password",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        },
        bottomBar = {
            // Submit Button - Fixed at bottom with proper insets
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Button(
                    onClick = {
                        if (currentPassword.isNotEmpty() && newPassword.isNotEmpty() && retypePassword.isNotEmpty()) {
                            if (newPassword == retypePassword) {
                                // Client-side validation
                                if (newPassword.length < 8) {
                                    errorMessage = "Password must be at least 8 characters long"
                                } else if (!newPassword.any { it.isDigit() }) {
                                    errorMessage = "Password must contain at least one number"
                                } else if (!newPassword.any { it.isLetter() }) {
                                    errorMessage = "Password must contain at least one letter"
                                } else {
                                    isLoading = true
                                    errorMessage = ""
                                    viewModel.changePassword(currentPassword, newPassword)
                                }
                            } else {
                                errorMessage = "Passwords do not match"
                            }
                        } else {
                            errorMessage = "Please fill in all fields"
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF504EC3)
                    ),
                    shape = RoundedCornerShape(100.dp),
                    enabled = !isLoading
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Changing Password...",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                lineHeight = 22.sp,
                                color = Color.White
                            )
                        } else {
                            Text(
                                text = "Submit New Password",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                lineHeight = 22.sp,
                                color = Color.White
                            )
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Submit",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { padding ->
        // Content - scrollable content area
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Current Password Section
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Instructional text
                Text(
                    text = "Please input your current password first",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 15.sp,
                    color = Color(0xFF504EC3)
                )
                
                // Current Password Field
                PasswordField(
                    label = "Current Password",
                    value = currentPassword,
                    onValueChange = { currentPassword = it },
                    placeholder = "*********"
                )
            }
            
            // Divider between sections
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEFEEF0),
                thickness = 1.dp
            )
            
            // New Password Section
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Instructional text
                Text(
                    text = "Now, create your new password",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 15.sp,
                    color = Color(0xFF504EC3)
                )
                
                // New Password Field
                PasswordField(
                    label = "New Password",
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    placeholder = "*********"
                )
                
                // Caption
                Text(
                    text = "Password must be at least 8 characters and contain letters and numbers",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 15.sp,
                    color = Color(0xFFC8C5CB)
                )
            }
            
            // Retype New Password Section
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Retype Password Field
                PasswordField(
                    label = "Retype New Password",
                    value = retypePassword,
                    onValueChange = { retypePassword = it },
                    placeholder = "*********"
                )
            }
            
            // Error message
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color(0xFFDC2626),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun PasswordField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    var passwordVisible by remember { mutableStateOf(false) }
    
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Label
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = Color(0xFF180E25)
        )
        
        // Input Field
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            placeholder = { 
                Text(
                    text = placeholder,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    color = Color(0xFFC8C5CB)
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                if (value.isNotEmpty()) {
                    TextButton(
                        onClick = { passwordVisible = !passwordVisible }
                    ) {
                        Text(
                            text = if (passwordVisible) "Hide" else "Show",
                            color = Color(0xFF504EC3),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF504EC3),
                unfocusedBorderColor = Color(0xFFC8C5CB),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = Color(0xFF504EC3)
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )
    }
}