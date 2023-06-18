package com.ai.challenge.alexklars.movies.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ai.challenge.alexklars.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Transaction
    suspend fun updateMovies(movies: List<Movie>) {
        deleteAllMovies()
        insertMovies(movies)
    }
}