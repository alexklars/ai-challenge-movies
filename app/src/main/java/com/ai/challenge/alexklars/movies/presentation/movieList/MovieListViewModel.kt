package com.ai.challenge.alexklars.movies.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.challenge.alexklars.movies.data.remote.model.Movie
import com.ai.challenge.alexklars.movies.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _originalMovies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    private val _filteredMovies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    private val _sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.NONE)
    private val _filterState: MutableStateFlow<FilterState> = MutableStateFlow(FilterState.NONE)

    val movies: StateFlow<List<Movie>> = _filteredMovies.asStateFlow()
    val sortType: StateFlow<SortType> = _sortType.asStateFlow()
    val filterState: StateFlow<FilterState> = _filterState.asStateFlow()

    init {
        viewModelScope.launch {
            movieRepository.updateMovies()
        }
        viewModelScope.launch {
            movieRepository.getMovies().collect {
                _originalMovies.value = it
                applyFilerAndSort()
            }
        }
    }

    fun onMovieClicked(movieId: String) {
        println("Clicked movie ID: $movieId")
    }

    fun setSortType(sortType: SortType) {
        _sortType.value = sortType
        applyFilerAndSort()
    }

    fun setFilterState(filterState: FilterState) {
        _filterState.value = filterState
        applyFilerAndSort()
    }

    private fun applyFilerAndSort() {
        _filteredMovies.value = _originalMovies.value
            .filter(filterState.value)
            .sort(sortType.value)
    }
}

private fun List<Movie>.sort(sortType: SortType): List<Movie> {
    return when (sortType) {
        SortType.PRICE_LOW_TO_HIGH -> sortedBy { it.price }
        SortType.PRICE_HIGH_TO_LOW -> sortedByDescending { it.price }
        SortType.NAME_A_TO_Z -> sortedBy { it.name }
        SortType.NAME_Z_TO_A -> sortedByDescending { it.name }
        else -> this
    }
}

private fun List<Movie>.filter(filterState: FilterState): List<Movie> {
    return when (filterState) {
        is FilterState.PriceRange -> {
            filter { movie ->
                movie.price in filterState.minPrice..filterState.maxPrice
            }
        }
        FilterState.NONE -> this
    }
}
