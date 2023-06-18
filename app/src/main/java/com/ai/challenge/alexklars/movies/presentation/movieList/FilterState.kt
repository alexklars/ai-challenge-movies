package com.ai.challenge.alexklars.movies.presentation.movieList

sealed class FilterState {

    object NONE : FilterState()

    data class PriceRange(
        val minPrice: Double,
        val maxPrice: Double
    ) : FilterState()
}
