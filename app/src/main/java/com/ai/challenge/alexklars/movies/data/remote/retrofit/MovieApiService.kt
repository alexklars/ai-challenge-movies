package com.ai.challenge.alexklars.movies.data.remote.retrofit

import com.ai.challenge.alexklars.movies.domain.model.Movie
import com.ai.challenge.alexklars.movies.domain.model.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movies")
    suspend fun getMovies(): List<Movie>

    @GET("movieDetails")
    suspend fun getMovieDetails(@Query("id") movieId: String): MovieDetails
}
