package com.ai.challenge.alexklars.movies.presentation.movieList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ai.challenge.alexklars.movies.presentation.movieList.component.FilterComponent
import com.ai.challenge.alexklars.movies.presentation.movieList.component.MovieItemComponent
import com.ai.challenge.alexklars.movies.presentation.movieList.component.SortOptionsComponent
import com.ai.challenge.alexklars.movies.presentation.navigation.AppDestinations

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieListScreen(
    navController: NavHostController,
    viewModel: MovieListViewModel,
) {
    val movies by viewModel.movies.collectAsState()
    val sortType by viewModel.sortType.collectAsState()
    val filterState by viewModel.filterState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies Shop") },
            )
        }
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SortOptionsComponent(
                    sortType = sortType,
                    onSortSelected = viewModel::setSortType
                )
                FilterComponent(
                    filterState = filterState,
                    onFilterSelected = viewModel::setFilterState
                )
            }
            LazyColumn() {
                items(movies) { movie ->
                    MovieItemComponent(
                        movie = movie,
                        onItemClick = {
                            navController.navigate("${AppDestinations.MovieDetailsScreen}/$it")
                        }
                    )
                }
            }
        }
    }
}
