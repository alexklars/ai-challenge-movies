package com.ai.challenge.alexklars.movies.presentation.movieList.component

import androidx.compose.foundation.clickable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ai.challenge.alexklars.movies.domain.model.Movie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItemComponent(
    modifier: Modifier = Modifier,
    movie: Movie,
    onItemClick: (String) -> Unit,
) {
    ListItem(
        modifier = modifier.clickable { onItemClick(movie.id) },
        text = {
            Text(text = movie.name)
        },
        secondaryText = {
            Text(text = "Price: $${movie.price}")
        },
    )
}