package com.ahmrh.movieapp.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahmrh.movieapp.feature.movie.ui.screen.detail.DetailScreen
import com.ahmrh.movieapp.feature.movie.ui.screen.explore.ExploreScreen
import com.ahmrh.movieapp.feature.movie.ui.screen.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {

    val navigateToHome: () -> Unit = {
        navController.navigate(Destination.Home.route){
            popUpTo(Destination.Home.route){ inclusive = true }
        }
    }
    val navigateToExplore: () -> Unit = {
        navController.navigate(Destination.Explore.route){
            popUpTo(Destination.Explore.route){ inclusive = true }
        }
    }

    val navigateToMovie: (Int) -> Unit = { movieId ->
        navController.navigate(Destination.Movie.createRoute(movieId))
    }

    val navigateToReview: (Int) -> Unit = { movieId ->
        navController.navigate(Destination.Review.createRoute(movieId))
    }

    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }

    NavHost(navController = navController, startDestination = Destination.Movie.createRoute(533535)){

        /*
        * "Delete the navigation of each feature before deleting one of the feature directory"
        * */


        // movie
        composable(Destination.Home.route){
            HomeScreen(
                navigateToExplore = navigateToExplore,
                navigateToMovie = navigateToMovie
            )
        }
        composable(Destination.Explore.route){
            ExploreScreen(
                navigateToHome = navigateToHome,
                navigateToMovie = navigateToMovie,
            )
        }
        composable(Destination.Bookmark.route){

        }

        composable(Destination.Movie.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")

            DetailScreen(movieId = 533535)


        }
        composable(Destination.Review.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")

        }

        // other feature


        // another feature
    }

}