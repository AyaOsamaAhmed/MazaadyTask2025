package com.aya.mazaadytask.detailsMovie

import com.aya.data.database.MovieEntity

data class DetailsMovieState (
    val isLoading: Boolean = false,
    val movie: MovieEntity? = null,
    val error: String? = null
)