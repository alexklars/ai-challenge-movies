package com.ai.challenge.alexklars.movies.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey
    val id: String,
    val name: String,
    val price: Double
)
