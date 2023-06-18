package com.ai.challenge.alexklars.movies.presentation.movieDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.challenge.alexklars.movies.domain.model.MovieDetails
import com.ai.challenge.alexklars.movies.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails.asStateFlow()

    init {
        fetchMovieDetails()
    }

    private fun fetchMovieDetails() {
        viewModelScope.launch {
            val movieId = savedStateHandle.get<String>("movieId")
                ?: error("You must pass movieId to MovieDetailsViewModel")
            val movieDetails = movieRepository.getMovieDetails(movieId)
            _movieDetails.value = movieDetails
        }
    }
}
