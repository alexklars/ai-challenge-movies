package com.ai.challenge.alexklars.movies.di

import android.app.Application
import androidx.room.Room
import com.ai.challenge.alexklars.movies.data.local.room.MovieDao
import com.ai.challenge.alexklars.movies.data.local.room.MovieDatabase
import com.ai.challenge.alexklars.movies.data.remote.MovieRemoteDataSourceImpl
import com.ai.challenge.alexklars.movies.data.remote.retrofit.MovieApiService
import com.ai.challenge.alexklars.movies.data.remote.retrofit.RetrofitClient
import com.ai.challenge.alexklars.movies.domain.remote.MovieRemoteDataSource
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
    fun provideMovieDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(application, MovieDatabase::class.java, "movie_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieApiService)
    }
}