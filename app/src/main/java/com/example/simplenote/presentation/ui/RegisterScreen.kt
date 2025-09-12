package com.example.simplenote.presentation.ui

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.presentation.auth.AuthState
import com.example.simplenote.presentation.auth.AuthViewModel

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    onLoginClick: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var localError by remember { mutableStateOf("") }

    val state by viewModel.authState.collectAsState()

    LaunchedEffect(state) {
        // We now listen for the final Success state which comes from the automatic login
        if (state is AuthState.Success) {
            // No need to reset state here, the navigation will take care of it
            onRegisterSuccess()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        // Status Bar spacer
        Spacer(modifier = Modifier.height(42.dp))
        
        // Nav Bar - exact CSS specifications
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF504EC3),
                modifier = Modifier.size(20.dp)
            )
            TextButton(
                onClick = onLoginClick,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Back to Login",
                    color = Color(0xFF504EC3),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp // 140% of 16px
                )
            }
        }
        
        // Screen Title - Fixed position (not scrollable)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Register",
                fontSize = 32.sp, // text-2xl/bold
                fontWeight = FontWeight.Bold,
                color = Color(0xFF180E25), // Neutral/Black
                lineHeight = 38.sp // 120% of 32px
            )
            Text(
                text = "And start taking notes",
                fontSize = 16.sp, // text-base/regular
                fontWeight = FontWeight.Normal,
                color = Color(0xFF827D89), // Neutral/Dark Grey
                lineHeight = 22.sp // 140% of 16px
            )
        }
        
        // Scrollable Content - exact CSS specifications
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            // Input Fields & Actions - exact CSS specifications
            Column(
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                // Input Fields - exact CSS specifications
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    // First Name field
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "First Name",
                            fontSize = 16.sp, // text-base/medium
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF180E25), // Neutral/Black
                            lineHeight = 22.sp // 140% of 16px
                        )
                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { newValue: String -> firstName = newValue },
                            placeholder = { Text("Example: Taha") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp)
                        )
                    }

                    // Last Name field
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Last Name",
                            fontSize = 16.sp, // text-base/medium
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF180E25), // Neutral/Black
                            lineHeight = 22.sp // 140% of 16px
                        )
                        OutlinedTextField(
                            value = lastName,
                            onValueChange = { newValue: String -> lastName = newValue },
                            placeholder = { Text("Example: Hamifar") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp)
                        )
                    }

                    // Username field
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Username",
                            fontSize = 16.sp, // text-base/medium
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF180E25), // Neutral/Black
                            lineHeight = 22.sp // 140% of 16px
                        )
                        OutlinedTextField(
                            value = username,
                            onValueChange = { newValue: String -> username = newValue },
                            placeholder = { Text("Example: @HamifarTaha") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp)
                        )
                    }

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
                            placeholder = { Text("Example: hamifar.taha@gmail.com") },
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

                    // Retype Password field
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Retype Password",
                            fontSize = 16.sp, // text-base/medium
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF180E25), // Neutral/Black
                            lineHeight = 22.sp // 140% of 16px
                        )
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { newValue: String -> confirmPassword = newValue },
                            placeholder = { Text("********") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                if (confirmPassword.isNotEmpty()) {
                                    TextButton(
                                        onClick = { confirmPasswordVisible = !confirmPasswordVisible }
                                    ) {
                                        Text(
                                            text = if (confirmPasswordVisible) "Hide" else "Show",
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
                    // Register button
                    Button(
                        onClick = {
                            localError = ""
                            if (password != confirmPassword) {
                                localError = "Passwords do not match"
                            } else if (firstName.isBlank() || lastName.isBlank() || username.isBlank() || email.isBlank() || password.isBlank()) {
                                localError = "All fields are required"
                            } else {
                                viewModel.register(firstName, lastName, username, email, password)
                            }
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
                            text = "Register",
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

                    // Login button - exact CSS specifications
                    Button(
                        onClick = {
                            viewModel.resetState()
                            onLoginClick()
                        },
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
                            text = "Already have an account? Login here",
                            color = Color(0xFF504EC3), // Primary/Base
                            fontSize = 14.sp, // slightly smaller font
                            fontWeight = FontWeight.Medium,
                            lineHeight = 20.sp, // adjusted line height
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Error states
            if (localError.isNotBlank()) {
                Text(
                    text = localError,
                    color = Color(0xFFDC2626),
                    fontSize = 14.sp
                )
            }

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
                is AuthState.Error -> Text(
                    text = "Error: ${(state as AuthState.Error).message}",
                    color = Color(0xFFDC2626),
                    fontSize = 14.sp
                )
                else -> {}
            }
        }
    }
}