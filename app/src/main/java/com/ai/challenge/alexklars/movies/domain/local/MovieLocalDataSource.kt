package com.ai.challenge.alexklars.movies.domain.local

import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getMovies(): Flow<List<Movie>>

    suspend fun updateMovies(movies: List<Movie>)
}
