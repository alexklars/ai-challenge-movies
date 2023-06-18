package com.ai.challenge.alexklars.movies.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ai.challenge.alexklars.movies.domain.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}