package com.ai.challenge.alexklars.movies.domain.remote

import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import com.ai.challenge.alexklars.movies.data.remote.model.MovieDetails

interface MovieRemoteDataSource {

    suspend fun getMovies(): List<Movie>

    suspend fun getMovieDetails(movieId: String): MovieDetails
}