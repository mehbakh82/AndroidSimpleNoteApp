package com.example.simplenote.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplenote.data.local.dao.NoteDao
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.domain.model.Note

class LocalNotePagingSource(
    private val noteDao: NoteDao,
    private val query: String,
    private val userId: Int
) : PagingSource<Int, Note>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Note> {
        val page = params.key ?: 0
        val pageSize = params.loadSize
        
        return try {
            val notes = if (query.isBlank()) {
                // Get all notes with pagination for specific user
                noteDao.getAllNotesPaged(userId, page * pageSize, pageSize)
            } else {
                // Search notes with pagination for specific user
                noteDao.searchNotesPaged(userId, query, page * pageSize, pageSize)
            }
            
            LoadResult.Page(
                data = notes.map { it.toNote() },
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (notes.size < pageSize) null else page + 1
            )
        } catch (e: Exception) {
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
