package com.aya.mazaadytask.ui.movie_details

import com.aya.mazaadytask.base.Action

sealed class MovieDetailsEvent : Action {
    data class GetMovieDetailsById(val movieId: Long) : MovieDetailsEvent()
    data class SaveMovieId(val movieId: Long) : MovieDetailsEvent()
    object MarkMovieAsFavorite : MovieDetailsEvent()
}