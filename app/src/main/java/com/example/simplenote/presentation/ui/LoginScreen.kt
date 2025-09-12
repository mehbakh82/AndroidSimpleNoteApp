package com.example.simplenote.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.presentation.auth.AuthState
import com.example.simplenote.presentation.auth.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onRegister: () -> Unit,
    onForgotPassword: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val state by viewModel.authState.collectAsState()

    // Clear any previous auth state (e.g., lingering Success) when entering this screen
    LaunchedEffect(Unit) {
        viewModel.resetState()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Top spacer for status bar
        Spacer(modifier = Modifier.height(69.dp)) // 101px - 32px padding = 69dp
        
        // Header section - exact CSS specifications
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Let's Login",
                fontSize = 32.sp, // text-2xl/bold
                fontWeight = FontWeight.Bold,
                color = Color(0xFF180E25), // Neutral/Black
                lineHeight = 38.sp // 120% of 32px
            )
            Text(
                text = "And notes your idea",
                fontSize = 16.sp, // text-base/regular
                fontWeight = FontWeight.Normal,
                color = Color(0xFF827D89), // Neutral/Dark Grey
                lineHeight = 22.sp // 140% of 16px
            )
        }

        // Input Fields - exact CSS specifications
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Email field
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Email Address",
                    fontSize = 16.sp, // text-base/medium
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF180E25), // Neutral/Black
                    lineHeight = 22.sp // 140% of 16px
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { newValue: String -> email = newValue },
                    placeholder = { Text("Example: johndoe@gmail.com") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                )
            }

            // Password field
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Password",
                    fontSize = 16.sp, // text-base/medium
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF180E25), // Neutral/Black
                    lineHeight = 22.sp // 140% of 16px
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { newValue: String -> password = newValue },
                    placeholder = { Text("********") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        if (password.isNotEmpty()) {
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

        // Actions - exact CSS specifications
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Login button
            Button(
                onClick = {
                    viewModel.login(email, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp), // height: 54px from CSS
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF504EC3) // Primary/Base
                ),
                shape = RoundedCornerShape(100.dp) // border-radius: 100px
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 16.sp, // text-base/medium
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp // 140% of 16px
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Or separator - exact CSS specifications
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFEFEEF0), // Neutral/Light Grey
                    thickness = 1.dp
                )
                Text(
                    text = "Or",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color(0xFF827D89), // Neutral/Dark Grey
                    fontSize = 12.sp, // text-2xs/medium
                    fontWeight = FontWeight.Medium,
                    lineHeight = 15.sp // identical to box height
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFEFEEF0), // Neutral/Light Grey
                    thickness = 1.dp
                )
            }

            // Register button - exact CSS specifications
            Button(
                onClick = onRegister,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp), // height: 54px from CSS
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(100.dp), // border-radius: 100px
                contentPadding = PaddingValues(8.dp, 16.dp) // reduced padding
            ) {
                Text(
                    text = "Don't have an account? Register here",
                    color = Color(0xFF504EC3), // Primary/Base
                    fontSize = 14.sp, // slightly smaller font
                    fontWeight = FontWeight.Medium,
                    lineHeight = 20.sp, // adjusted line height
                    textAlign = TextAlign.Center
                )
            }
        }

        // Error state
        when (state) {
            is AuthState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = Color(0xFF504EC3)
                    )
                }
            }
            is AuthState.Success -> { /* No UI; graph will switch due to token change */ }
            is AuthState.Error -> Text(
                "Error: ${(state as AuthState.Error).message}",
                color = Color(0xFFDC2626),
                fontSize = 14.sp
            )
            else -> {}
        }
    }
}
