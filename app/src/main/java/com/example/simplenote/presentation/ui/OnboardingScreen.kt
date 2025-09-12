package com.example.simplenote.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.R

@Composable
fun OnboardingScreen(onGetStarted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF504EC3)) // Primary/Base color from CSS
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 40.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top spacer for status bar
            Spacer(modifier = Modifier.height(40.dp))
            
            // Illustration placeholder - you'll need to add the actual illustration
            Box(
                modifier = Modifier
                    .size(280.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                // Placeholder for the illustration with person, lightbulb, papers, etc.
                // You'll need to create this as a drawable or use a vector
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), 
                    contentDescription = "Onboarding illustration",
                    modifier = Modifier.size(200.dp)
                )
            }
            
            // Main text content - positioned exactly as in CSS
            Text(
                text = "Jot Down anything you want to achieve, today or in the future",
                color = Color.White,
                fontSize = 20.sp, // text-lg/bold from CSS
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 28.sp, // 140% of 20px
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            
            // Get Started button - exact CSS styling
            Button(
                onClick = onGetStarted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp) // height: 54px from CSS
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(100.dp), // border-radius: 100px from CSS
                border = BorderStroke(1.dp, Color(0xFF504EC3)) // border: 1px solid #504EC3
            ) {
                Text(
                    text = "Let's Get Started",
                    color = Color(0xFF504EC3), // Primary/Base color
                    fontSize = 16.sp, // text-base/medium
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp // 140% of 16px
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color(0xFF504EC3),
                    modifier = Modifier.size(20.dp)
                )
            }
            
            // Bottom spacer
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
