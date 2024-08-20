package com.ahmrh.movieapp.core.ui.navigation

sealed class Destination(val route: String) {

    data object Home: Destination("home")

    data object Explore: Destination("explore")

    data object Movie: Destination("movie/{movieId}"){
        fun createRoute(movieId: Int) = "movie/$movieId"
    }

    data object Review: Destination("movie/{movieId}/reviews"){
        fun createRoute(movieId: Int) = "movie/$movieId/reviews"

    }

    data object Bookmark: Destination("bookmark")

}