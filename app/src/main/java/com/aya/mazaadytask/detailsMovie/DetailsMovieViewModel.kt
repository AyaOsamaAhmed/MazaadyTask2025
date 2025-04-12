package com.aya.mazaadytask.detailsMovie

import androidx.lifecycle.viewModelScope
import com.aya.data.repository.MovieRepositoryImpl
import com.aya.mazaadytask.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsMovieViewModel @Inject constructor(
    private val repo: MovieRepositoryImpl
) : BaseViewModel() {

    private val _state = MutableStateFlow(DetailsMovieState())
    val state = _state.asStateFlow()

    fun onEvent(event: DetailsMovieEvent) {
        when (event) {
            is DetailsMovieEvent.GetMovieById -> getMovieById(event.movieId)
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

}