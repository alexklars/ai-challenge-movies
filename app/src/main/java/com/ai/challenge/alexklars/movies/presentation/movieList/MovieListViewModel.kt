package com.ai.challenge.alexklars.movies.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import com.ai.challenge.alexklars.movies.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies.asStateFlow()

    private val _sortType = MutableStateFlow(SortType.NONE)
    val sortType: StateFlow<SortType> = _sortType.asStateFlow()

    init {
        viewModelScope.launch {
            movieRepository.updateMovies()
        }
        viewModelScope.launch {
            movieRepository.getMovies().collect {
                _movies.value = it
            }
        }
    }

    fun onMovieClicked(movieId: String) {
        println("Clicked movie ID: $movieId")
    }

    fun applySort(sortType: SortType) {
        _sortType.value = sortType
        updateSortedMovies()
    }

    private fun updateSortedMovies() {
        val sortedMovies = when (sortType.value) {
            SortType.PRICE_LOW_TO_HIGH -> movies.value.sortedBy { it.price }
            SortType.PRICE_HIGH_TO_LOW -> movies.value.sortedByDescending { it.price }
            SortType.NAME_A_TO_Z -> movies.value.sortedBy { it.name }
            SortType.NAME_Z_TO_A -> movies.value.sortedByDescending { it.name }
            else -> movies.value
        }
        _movies.value = sortedMovies
    }
}