package com.ai.challenge.alexklars.movies.domain

import com.ai.challenge.alexklars.movies.domain.model.Movie
import com.ai.challenge.alexklars.movies.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<List<Movie>>

    suspend fun updateMovies()

    suspend fun getMovieDetails(movieId: String): MovieDetails
}