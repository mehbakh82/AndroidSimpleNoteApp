package com.example.simplenote.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeEmptyStateScreen(
    onAddNoteClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8FC))
    ) {
        // Main Content
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Main Content Area - Exact Figma specifications
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                // Title & Description - Centered properly
                Column(
                    modifier = Modifier
                        .width(237.dp)
                        .height(105.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Title - Exact CSS specifications
                    Text(
                        text = "Start Your Journey",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 29.sp, // 120% of 24px
                        textAlign = TextAlign.Center,
                        color = Color(0xFF180E25),
                        modifier = Modifier.width(221.dp)
                    )
                    
                    // Description - Exact CSS specifications
                    Text(
                        text = "Every big step start with small step. Notes your first idea and start your journey!",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp, // 140% of 14px
                        textAlign = TextAlign.Center,
                        color = Color(0xFF827D89),
                        modifier = Modifier.width(237.dp)
                    )
                }
            }
            
            // Bottom Navigation Bar
            HomeBottomNavigationBar(
                onSettingsClick = onSettingsClick
            )
        }
        
        // Floating Action Button - Keep the FAB for adding notes
        CenterFloatingActionButton(
            onClick = onAddNoteClick,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-43.99).dp)
        )
    }
}




@Composable
fun HomeBottomNavigationBar(
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-16).dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side - Home (Active) - Purple icon and label, NO circle background
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                // Home Icon - Purple house directly, no circle
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = Color(0xFF504EC3),
                    modifier = Modifier.size(32.dp)
                )
                
                Text(
                    text = "Home",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF504EC3)
                )
            }
            
            // Right side - Settings (Inactive) - Grey gear icon directly, NO circle
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable { onSettingsClick() }
            ) {
                // Settings Icon - Grey gear icon directly, NO circle border
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Settings",
                    tint = Color(0xFF827D89),
                    modifier = Modifier.size(32.dp)
                )
                
                Text(
                    text = "Settings",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF827D89)
                )
            }
        }
    }
}

@Composable
fun CenterFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color(0xFFFAF8FC), CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        // Inner Button - Purple circle with larger white plus directly inside
        Box(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .background(Color(0xFF504EC3), CircleShape)
                .shadow(
                    elevation = 4.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.2f)
                ),
            contentAlignment = Alignment.Center
        ) {
            // Larger plus sign
            Text(
                text = "+",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}
