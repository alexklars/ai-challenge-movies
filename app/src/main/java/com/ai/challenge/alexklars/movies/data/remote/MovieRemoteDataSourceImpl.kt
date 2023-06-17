package com.ai.challenge.alexklars.movies.data.remote

import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import com.ai.challenge.alexklars.movies.data.remote.model.MovieDetails
import com.ai.challenge.alexklars.movies.data.remote.retrofit.MovieApiService
import com.ai.challenge.alexklars.movies.domain.remote.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): List<Movie> {
        return movieApiService.getMovies()
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetails {
        return movieApiService.getMovieDetails(movieId)
    }
}
