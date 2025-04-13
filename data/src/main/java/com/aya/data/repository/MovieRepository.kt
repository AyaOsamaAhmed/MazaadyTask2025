package com.aya.data.repository

import androidx.paging.PagingData
import com.aya.data.database.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<PagingData<MovieEntity>>
    suspend fun toggleFavorite(movieId: Long, isFavorite: Boolean)
    suspend fun getMovie(movieId: Long):Flow<MovieEntity>
}