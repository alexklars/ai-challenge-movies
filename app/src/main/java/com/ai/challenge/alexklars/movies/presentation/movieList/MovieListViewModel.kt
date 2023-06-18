package com.ai.challenge.alexklars.movies.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import com.ai.challenge.alexklars.movies.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies

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
    }
}