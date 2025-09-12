@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.simplenote.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.presentation.home.AddNoteViewModel

@Composable
fun AddNoteScreen(
    viewModel: AddNoteViewModel,
    onNoteSaved: () -> Unit,
    onBackPressed: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val noteCreated by viewModel.noteCreated.collectAsState()

    LaunchedEffect(noteCreated) {
        if (noteCreated) {
            viewModel.resetNoteCreated()
            onNoteSaved()
        }
    }

    fun saveIfNeededOrBack() {
        val hasContent = title.isNotBlank() || content.isNotBlank()
        if (hasContent) {
            viewModel.addNote(title.trim(), content.trim())
        } else {
            onBackPressed()
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
                    .shadow(elevation = 0.dp)
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
                        .clickable { saveIfNeededOrBack() },
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
            }
        },
        bottomBar = {
            // Task Bar respecting navigation bar insets
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .height(48.dp)
                    .background(Color.White)
            ) {
                HorizontalDivider(
                    modifier = Modifier.align(Alignment.TopCenter),
                    color = Color(0xFFEFEEF0),
                    thickness = 1.dp
                )
                // Trash button on right
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .background(Color(0xFF504EC3)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Color.White
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            // Content block positioned with top spacing below app bar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Title input (32sp bold)
                BasicTextField(
                    value = title,
                    onValueChange = { title = it },
                    textStyle = TextStyle(
                        color = Color(0xFF180E25),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 38.sp
                    ),
                    singleLine = true,
                    decorationBox = { inner ->
                        if (title.isEmpty()) {
                            Text(
                                text = "Title",
                                color = Color(0xFF180E25),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        inner()
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Body input (placeholder 16sp grey)
                BasicTextField(
                    value = content,
                    onValueChange = { content = it },
                    textStyle = TextStyle(
                        color = Color(0xFF180E25),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 22.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    decorationBox = { inner ->
                        if (content.isEmpty()) {
                            Text(
                                text = "Feel Free to Write Here…",
                                color = Color(0xFF827D89),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 22.sp
                            )
                        }
                        inner()
                    }
                )
            }
        }
    }
}