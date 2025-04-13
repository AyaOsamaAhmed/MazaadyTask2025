package com.aya.mazaadytask.ui.list_movies

import androidx.paging.PagingData
import com.aya.data.database.MovieEntity

data class ListMoviesState(
    val isLoading: Boolean = false,
    val moviesPaging: PagingData<MovieEntity>? = null,
    val error: String? = null,
    val isGridSortLayout: Boolean = false,
)