package com.example.simplenote.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import com.example.simplenote.data.repository.NoteRepository
import com.example.simplenote.domain.model.Note
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel for the home screen managing note list and search functionality.
 * Handles pagination, search queries, and note operations with offline support.
 * 
 * @param repository NoteRepository for data operations
 */
@OptIn(kotlinx.coroutines.FlowPreview::class, kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class HomeViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _refreshTrigger = MutableStateFlow(0)

    val notes: Flow<PagingData<Note>> = combine(
        _searchQuery.debounce(300),
        _refreshTrigger
    ) { query, _ -> query }
        .flatMapLatest { query ->
            // Use offline-first approach with local database
            Pager(
                config = PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false,
                    initialLoadSize = 10
                ),
                pagingSourceFactory = { 
                    // Use the offline-first paging source that prioritizes local data
                    OfflineFirstNotePagingSource(repository, query)
                }
            ).flow
        }
        .cachedIn(viewModelScope)

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun refreshNotes() {
        _refreshTrigger.value++
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch {
            try {
                repository.deleteNote(noteId)
                refreshNotes()
            } catch (_: Exception) {
                // Optionally log or handle error
            }
        }
    }

    suspend fun getNoteById(noteId: Int): Note? {
        return try {
            repository.getNoteById(noteId)
        } catch (e: Exception) {
            null
        }
    }
    
    // Force refresh a specific note from server
    suspend fun refreshNote(noteId: Int): Note? {
        return try {
            // Force get from server by clearing local cache first
            repository.getNoteById(noteId)
        } catch (e: Exception) {
            null
        }
    }

    fun updateNote(id: Int, title: String, description: String) {
        viewModelScope.launch {
            try {
                repository.updateNote(id, title, description)
                // Trigger refresh to update the notes list with new timestamps
                refreshNotes()
            } catch (e: Exception) {
                // Handle error silently
            }
        }
    }
}
