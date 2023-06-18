package com.ai.challenge.alexklars.movies.data.local

import com.ai.challenge.alexklars.movies.data.local.room.MovieDao
import com.ai.challenge.alexklars.movies.domain.dataSourcies.MovieLocalDataSource
import com.ai.challenge.alexklars.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalDataSource {
    override fun getMovies(): Flow<List<Movie>> {
        return movieDao.getMovies()
    }

    override suspend fun updateMovies(movies: List<Movie>) {
        movieDao.updateMovies(movies)
    }
}
