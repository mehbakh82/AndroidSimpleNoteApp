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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenote.domain.model.Note
import com.example.simplenote.presentation.home.HomeViewModel
import com.example.simplenote.utils.TimeZoneUtils
import kotlinx.coroutines.launch

@Composable
fun NoteDetailScreen(
    noteId: Int,
    viewModel: HomeViewModel,
    onBack: () -> Unit
) {
    var note by remember { mutableStateOf<Note?>(null) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var hasChanges by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // Load note data
    LaunchedEffect(noteId) {
        note = viewModel.getNoteById(noteId)
        note?.let {
            title = it.title
            content = it.description
        }
    }

    // Auto-save functionality
    fun saveChanges() {
        if (hasChanges && note != null) {
            scope.launch {
                viewModel.updateNote(noteId, title.trim(), content.trim())
                hasChanges = false
                // Refresh the notes list to show updated content
                viewModel.refreshNotes()
            }
        }
    }

    // Track changes
    LaunchedEffect(title, content) {
        if (note != null) {
            hasChanges = title != note!!.title || content != note!!.description
        }
    }

    // Save on back press
    fun handleBackPress() {
        saveChanges()
        // Refresh the notes list to show updated content
        viewModel.refreshNotes()
        onBack()
    }

    // Delete note
    fun deleteNote() {
        scope.launch {
            viewModel.deleteNote(noteId)
            // Refresh the notes list to show updated content
            viewModel.refreshNotes()
            onBack()
        }
    }

    if (note == null) {
        // Loading state
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
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
                        .clickable { handleBackPress() },
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
                Text(
                    text = note?.let { 
                        val formattedTime = TimeZoneUtils.formatTimestampForDisplay(it.updated_at)
                        "Last edited on $formattedTime"
                    } ?: "Loading...",
                    color = Color(0xFF000000),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                )
                // Trash button on right
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .background(Color(0xFF504EC3))
                        .clickable { showDeleteDialog = true },
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
                // Title input (32sp bold) - pre-filled with note title
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

                // Body input (placeholder 16sp grey) - pre-filled with note content
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

    // Custom delete confirmation modal
    DeleteNoteModal(
        isVisible = showDeleteDialog,
        onDismiss = { showDeleteDialog = false },
        onDelete = {
            showDeleteDialog = false
            deleteNote()
        }
    )
}