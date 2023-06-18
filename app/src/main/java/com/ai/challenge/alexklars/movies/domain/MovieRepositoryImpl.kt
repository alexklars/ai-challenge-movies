package com.ai.challenge.alexklars.movies.domain

import com.ai.challenge.alexklars.movies.domain.model.Movie
import com.ai.challenge.alexklars.movies.domain.model.MovieDetails
import com.ai.challenge.alexklars.movies.domain.dataSourcies.MovieLocalDataSource
import com.ai.challenge.alexklars.movies.domain.dataSourcies.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun getMovies(): Flow<List<Movie>> {
        return movieLocalDataSource.getMovies()
    }

    override suspend fun updateMovies() {
        val movies = movieRemoteDataSource.getMovies()
        movieLocalDataSource.updateMovies(movies)
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetails {
        return movieRemoteDataSource.getMovieDetails(movieId)
    }
}
