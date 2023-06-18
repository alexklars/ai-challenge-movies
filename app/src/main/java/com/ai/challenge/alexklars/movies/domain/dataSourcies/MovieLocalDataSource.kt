package com.ai.challenge.alexklars.movies.domain.dataSourcies

import com.ai.challenge.alexklars.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getMovies(): Flow<List<Movie>>

    suspend fun updateMovies(movies: List<Movie>)
}
