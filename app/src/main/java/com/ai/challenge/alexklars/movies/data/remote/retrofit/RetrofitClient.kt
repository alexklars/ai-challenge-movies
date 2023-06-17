package com.ai.challenge.alexklars.movies.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    private const val BASE_URL = "https://us-central1-testmodule-12b1c.cloudfunctions.net/"
    private const val BASE_URL = "https://us-central1-temporary-692af.cloudfunctions.net/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApiService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}
