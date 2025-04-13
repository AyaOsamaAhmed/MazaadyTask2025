package com.aya.mazaadytask.ui.movie_details

import androidx.lifecycle.viewModelScope
import com.aya.data.database.MovieEntity
import com.aya.data.repository.MovieRepositoryImpl
import com.aya.mazaadytask.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repo: MovieRepositoryImpl
) : BaseViewModel() {
    private val _state = MutableStateFlow(MovieDetailsState())
    val state = _state.asStateFlow()
    fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            is MovieDetailsEvent.GetMovieDetailsById -> getMovieById(event.movieId)
            is MovieDetailsEvent.SaveMovieId -> setMovieId(event.movieId)
            is MovieDetailsEvent.MarkMovieAsFavorite -> markMovieAsFavorite()
        }
    }
    private fun getMovieById(movieId: Long) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            repo.getMovie(movieId).collect{
            try{
                _state.value = _state.value.copy(isLoading = false , movie = it)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = e.message)
                }
            }
        }
    }
    private fun markMovieAsFavorite() {
        viewModelScope.launch {
            _state.value = _state.value.copy(movie = _state.value.movie!!.copy(isFavorite = !_state.value.movie!!.isFavorite))
            repo.toggleFavorite(_state.value.movieId!!, _state.value.movie!!.isFavorite)
        }
    }
    private fun setMovieId(movieId: Long) {
        _state.value = _state.value.copy(movieId = movieId)
    }
}