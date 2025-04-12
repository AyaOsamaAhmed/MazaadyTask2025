package com.aya.mazaadytask.detailsMovie

import com.aya.mazaadytask.base.Action

sealed class DetailsMovieEvent : Action {
    data class GetMovieById(val movieId: Long) : DetailsMovieEvent()
}