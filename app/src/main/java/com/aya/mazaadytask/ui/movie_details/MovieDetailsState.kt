package com.aya.mazaadytask.ui.movie_details

import com.aya.data.database.MovieEntity

data class MovieDetailsState (
    val isLoading: Boolean = false,
    val movie: MovieEntity? = null,
    val error: String? = null,
    val movieId : Long? = null
)