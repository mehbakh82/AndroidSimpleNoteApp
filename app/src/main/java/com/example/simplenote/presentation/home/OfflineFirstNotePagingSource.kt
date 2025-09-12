package com.example.simplenote.presentation.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplenote.data.repository.NoteRepository
import com.example.simplenote.domain.model.Note
import kotlinx.coroutines.flow.first

/**
 * Offline-first paging source that prioritizes local data and falls back to remote API.
 * This ensures the app works seamlessly both online and offline.
 * 
 * @param repository NoteRepository with access to both local and remote data sources
 * @param query Search query for filtering notes
 */
class OfflineFirstNotePagingSource(
    private val repository: NoteRepository,
    private val query: String
) : PagingSource<Int, Note>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Note> {
        val page = params.key ?: 0
        val pageSize = params.loadSize

        return try {
            // First, try to get data from local database
            val localNotes = repository.getLocalNotesPaged(query, page, pageSize)
            
            if (localNotes.isNotEmpty()) {
                // If we have local data, return it immediately
                LoadResult.Page(
                    data = localNotes,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (localNotes.size < pageSize) null else page + 1
                )
            } else {
                // If no local data, try to fetch from remote API
                val remoteNotes = repository.getRemoteNotesPaged(query, page + 1, pageSize) // API uses 1-based pagination
                
                // Save remote data to local database for future offline access
                if (remoteNotes.isNotEmpty()) {
                    repository.saveNotesToLocal(remoteNotes)
                }
                
                LoadResult.Page(
                    data = remoteNotes,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (remoteNotes.size < pageSize) null else page + 1
                )
            }
        } catch (e: Exception) {
            // If both local and remote fail, return error
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Note>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}
