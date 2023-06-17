package com.ai.challenge.alexklars.movies.di

import com.ai.challenge.alexklars.movies.data.remote.MovieRemoteDataSourceImpl
import com.ai.challenge.alexklars.movies.data.remote.retrofit.MovieApiService
import com.ai.challenge.alexklars.movies.data.remote.retrofit.RetrofitClient
import com.ai.challenge.alexklars.movies.domain.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        return RetrofitClient.movieApiService
    }

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieApiService)
    }
}