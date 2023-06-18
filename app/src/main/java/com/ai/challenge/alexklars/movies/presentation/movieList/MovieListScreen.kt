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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ai.challenge.alexklars.movies.presentation.movieList.component.MovieItemComponent
import com.ai.challenge.alexklars.movies.presentation.movieList.component.SortOptionsComponent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = viewModel()
) {
    val movies by viewModel.movies.collectAsState()
    val sortType by viewModel.sortType.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies Shop") },
            )
        }
    ) {
        Column {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                // Filter options UI
                // Implement UI for filter options based on your specific requirements
                // For example, a dropdown menu or sliders for price range

                // Sort options UI
                SortOptionsComponent(
                    sortType = sortType,
                    onSortSelected = viewModel::applySort,
                )
            }

            LazyColumn {
                items(movies) { movie ->
                    MovieItemComponent(
                        movie = movie,
                        onItemClick = viewModel::onMovieClicked,
                    )
                }
            }
        }
    }
}