package com.aya.mazaadytask.ui.list_movies

import com.aya.mazaadytask.base.Action

sealed class ListMoviesEvent : Action {
    object GetMovies : ListMoviesEvent()
    data class MarkMovieAsFavorite(val movieId: Long, val isFavorite: Boolean) : ListMoviesEvent()
    data class MarkSortGridLayout (val isSortGridLayout: Boolean) : ListMoviesEvent()
}