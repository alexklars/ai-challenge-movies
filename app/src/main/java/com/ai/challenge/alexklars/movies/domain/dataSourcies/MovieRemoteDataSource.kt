package com.ai.challenge.alexklars.movies.domain.dataSourcies

import com.ai.challenge.alexklars.movies.domain.model.Movie
import com.ai.challenge.alexklars.movies.domain.model.MovieDetails

interface MovieRemoteDataSource {

    suspend fun getMovies(): List<Movie>

    suspend fun getMovieDetails(movieId: String): MovieDetails
}