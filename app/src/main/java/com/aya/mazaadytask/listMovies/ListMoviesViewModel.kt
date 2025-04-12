package com.aya.mazaadytask.listMovies

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.aya.data.repository.MovieRepositoryImpl
import com.aya.mazaadytask.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListMoviesViewModel @Inject constructor(
    private val repo: MovieRepositoryImpl
) : BaseViewModel() {

    private val _state = MutableStateFlow(ListMoviesState())
    val state = _state.asStateFlow()

    fun onEvent(event: ListMoviesEvent) {
        when (event) {
            is ListMoviesEvent.GetMovies -> getListOfMovies()
            is ListMoviesEvent.MarkMovieAsFavorite -> markMovieAsFavorite(
                event.movieId,
                event.isFavorite.not()
            )
            is ListMoviesEvent.MarkSortGridLayout -> markSortGridLayout( event.isSortGridLayout)
        }
    }

    private fun getListOfMovies() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                repo.getMovies().cachedIn(viewModelScope)
                    .collect {
                    _state.value = _state.value.copy(isLoading = false, moviesPaging = it)
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    private fun markMovieAsFavorite(id: Long, isFavorite: Boolean) {
        viewModelScope.launch {
            repo.toggleFavorite(id, isFavorite)
        }
    }

    private fun markSortGridLayout(isSortGridLayout: Boolean){
        viewModelScope.launch {
            _state.value = _state.value.copy(isGridSortLayout = isSortGridLayout)
        }
    }
}