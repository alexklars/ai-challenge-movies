package com.ai.challenge.alexklars.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ai.challenge.alexklars.movies.domain.remote.MovieRemoteDataSource
import com.ai.challenge.alexklars.movies.presentation.navigation.NavGraph
import com.ai.challenge.alexklars.movies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var movieRemoteDataSource: MovieRemoteDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MoviesTheme {
                    NavGraph()
                }
            }
        }
    }
}
