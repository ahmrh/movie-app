package com.ahmrh.movieapp.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahmrh.movieapp.feature.movie.ui.screen.explore.ExploreScreen
import com.ahmrh.movieapp.feature.movie.ui.screen.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Destination.Home.route){

        /*
        * "Delete the navigation of each feature before deleting one of the feature directory"
        * - ahmrh
        * */


        // movie
        composable(Destination.Home.route){
            HomeScreen(navController)
        }
        composable(Destination.Explore.route){
            ExploreScreen(navController)
        }
        composable(Destination.Bookmark.route){

        }

        composable(Destination.Movie.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable


        }
        composable(Destination.Review.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable

        }

        // other feature


        // another feature
    }

}