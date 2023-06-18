package com.ai.challenge.alexklars.movies.presentation.movieDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailsScreen(
    navController: NavHostController,
    viewModel: MovieDetailsViewModel
) {
    val movieDetails by viewModel.movieDetails.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movie Details") },
                navigationIcon = {
                    IconButton(onClick = navController::popBackStack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            movieDetails?.let { details ->
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    item {
                        Text(
                            text = details.name,
                            style = MaterialTheme.typography.h6,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Price: $${details.price}",
                            style = MaterialTheme.typography.body1,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = details.meta,
                            style = MaterialTheme.typography.body1,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Image(
                            painter = rememberAsyncImagePainter(details.image),
                            contentDescription = "Movie Poster",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = details.synopsis,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    )
}
