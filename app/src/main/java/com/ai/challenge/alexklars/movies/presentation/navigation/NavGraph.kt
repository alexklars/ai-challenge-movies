package com.ai.challenge.alexklars.movies.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ai.challenge.alexklars.movies.presentation.movieDetails.MovieDetailsScreen
import com.ai.challenge.alexklars.movies.presentation.movieDetails.MovieDetailsViewModel
import com.ai.challenge.alexklars.movies.presentation.movieList.MovieListScreen
import com.ai.challenge.alexklars.movies.presentation.movieList.MovieListViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.MovieListScreenDestination,
    ) {
        composable(AppDestinations.MovieListScreenDestination) {
            val viewModel = hiltViewModel<MovieListViewModel>()
            MovieListScreen(navController, viewModel)
        }
        composable(
            AppDestinations.MovieDetailsScreenDestination,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<MovieDetailsViewModel>(backStackEntry)
            MovieDetailsScreen(navController, viewModel)
        }
    }
}