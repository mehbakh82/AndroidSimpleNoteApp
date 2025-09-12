package com.example.simplenote.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.simplenote.domain.model.Note
import com.example.simplenote.presentation.home.HomeViewModel
import com.example.simplenote.presentation.ui.components.OfflineIndicator
import com.example.simplenote.data.sync.SyncManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddNoteClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onNoteClick: (Int) -> Unit,
    syncManager: SyncManager? = null
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val notes = viewModel.notes.collectAsLazyPagingItems()

    // Check if we should show empty state (only when there are no notes AND no search query)
    val shouldShowEmptyState = notes.itemCount == 0 && 
        notes.loadState.refresh !is LoadState.Loading &&
        notes.loadState.refresh !is LoadState.Error &&
        searchQuery.isEmpty() // Only show empty state when not searching

    if (shouldShowEmptyState) {
        // Show empty state screen (only when there are no notes at all)
        HomeEmptyStateScreen(
            onAddNoteClick = onAddNoteClick,
            onSettingsClick = onSettingsClick
        )
    } else {
        // Show normal home screen with notes using the exact empty-state structure
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAF8FC))
        ) {
            Scaffold(
                containerColor = Color(0xFFFAF8FC),
                bottomBar = { HomeBottomNavigationBar(onSettingsClick = onSettingsClick) },
                floatingActionButton = {}
            ) { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ) {
                    // Offline indicator with null safety
                    syncManager?.let { 
                        OfflineIndicator(syncManager = it)
                    }
                // Search Bar container with bottom divider shadow - Figma specs
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .background(Color.White)
                        .shadow(elevation = 0.dp)
                ) {
                    HorizontalDivider(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        color = Color(0xFFEFEEF0),
                        thickness = 1.dp
                    )
                    // Auto layout with Figma specifications
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 9.dp), // 9px padding as per Figma
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp) // 12px gap as per Figma
                    ) {
                        // Back button - 24x24 as per Figma
                        Icon(
                            Icons.Default.Search, 
                            contentDescription = "Search", 
                            tint = Color(0xFF111827),
                            modifier = Modifier.size(24.dp)
                        )
                        
                        // Search Field - Figma specifications with actual text input
                        BasicTextField(
                            value = searchQuery,
                            onValueChange = viewModel::onSearchQueryChanged,
                            modifier = Modifier
                                .weight(1f) // Take all available space
                                .height(36.dp), // Exact height from Figma
                            textStyle = androidx.compose.ui.text.TextStyle(
                                color = Color(0xFF180E25), // Text color when typing
                                fontSize = 14.sp, // text-sm
                                fontWeight = FontWeight.Normal, // 400
                                lineHeight = 19.6.sp // 140% of 14px = 19.6px
                            ),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            Color(0xFFEFEEF0), // Neutral/Light Grey
                                            RoundedCornerShape(8.dp)
                                        )
                                        .padding(8.dp) // 8px padding as per Figma
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp) // 10px gap as per Figma
                                    ) {
                                        // Text field content
                                        Box(modifier = Modifier.weight(1f)) {
                                            if (searchQuery.isEmpty()) {
                                                // Placeholder text with exact Figma specifications
                                                Text(
                                                    text = "Search...",
                                                    color = Color(0xFFC8C5CB), // Neutral/Base Grey
                                                    fontSize = 14.sp, // text-sm
                                                    fontWeight = FontWeight.Normal, // 400
                                                    lineHeight = 19.6.sp // 140% of 14px = 19.6px
                                                )
                                            }
                                            innerTextField()
                                        }
                                        
                                        // Clear Search button - minimal design
                                        if (searchQuery.isNotBlank()) {
                                            IconButton(
                                                onClick = { viewModel.onSearchQueryChanged("") },
                                                modifier = Modifier.size(16.dp)
                                            ) {
                                                Icon(
                                                    Icons.Default.Close,
                                                    contentDescription = "Clear",
                                                    tint = Color(0xFF827D89), // Neutral/Dark Grey
                                                    modifier = Modifier.size(14.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        )
                    }
                }

                // Section Title
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Notes",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFF180E25),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Check if we should show empty search results
                val shouldShowEmptySearchResults = notes.itemCount == 0 && 
                    notes.loadState.refresh !is LoadState.Loading &&
                    notes.loadState.refresh !is LoadState.Error &&
                    searchQuery.isNotEmpty() // Only show when searching but no results

                if (shouldShowEmptySearchResults) {
                    // Empty search results state
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "No notes found",
                                color = Color(0xFF827D89),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "Try searching with different keywords",
                                color = Color(0xFF827D89),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                } else {
                    // Vertical grid layout to accommodate multiple notes
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 150.dp), // Adaptive columns based on screen width
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(notes.itemCount) { index ->
                            val note = notes[index]
                            if (note != null) {
                                val color = when (index % 3) {
                                    0 -> Color(0xFFF7F6D4) // Secondary/Light
                                    1 -> Color(0xFFFDEBAB) // Warning/Light
                                    else -> Color(0xFFF7DEE3) // Error/Light
                                }
                                NoteCardFigma(note = note, bg = color) { onNoteClick(note.id) }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(80.dp)) // Spacer above tab bar
                }
            }

            // Centered FAB overlay identical to empty state, anchored above the bar
            CenterFloatingActionButton(
                onClick = onAddNoteClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = (-43.99).dp)
                    .size(80.dp)
            )
        }
    }
}


// Vertical grid layout for better note display and space utilization

@Composable
fun NoteCardFigma(note: Note, bg: Color, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = bg),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(224.dp)
                .padding(12.dp)
        ) {
            Text(
                text = note.title,
                color = Color(0xFF180E25),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = note.description,
                color = Color(0xFF180E25).copy(alpha = 0.6f),
                fontSize = 10.sp,
                maxLines = 10,
                lineHeight = 12.sp
            )
        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
    }
}