package com.example.simplenote.data.remote

import com.example.simplenote.domain.model.FilterResponse
import com.example.simplenote.domain.model.Note
import com.example.simplenote.domain.model.NoteRequest
import com.example.simplenote.domain.model.UpdateNoteRequest
import retrofit2.Response
import retrofit2.http.*

interface NoteApi {

    @GET("notes/")
    suspend fun getNotes(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): NoteListResponse

    @GET("notes/filter")
    suspend fun filterNotes(
        @Query("title") title: String? = null,
        @Query("description") description: String? = null,
        @Query("updated__gte") updatedGte: String? = null,
        @Query("updated__lte") updatedLte: String? = null,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): NoteListResponse

    @POST("/api/notes/")
    suspend fun createNote(@Body note: NoteRequest): Note

    @DELETE("/api/notes/{id}/")
    suspend fun deleteNote(@Path("id") id: Int): Response<Unit>

    @GET("/api/notes/{id}/")
    suspend fun getNoteById(@Path("id") id: Int): Note

    @PUT("/api/notes/{id}/")
    suspend fun updateNote(
        @Path("id") id: Int,
        @Body note: UpdateNoteRequest
    ): Note


}


data class NoteListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Note>
)