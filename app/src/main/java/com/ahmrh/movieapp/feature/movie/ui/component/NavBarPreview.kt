package com.ahmrh.movieapp.feature.movie.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.ahmrh.movieapp.core.ui.navigation.Destination

@Composable
fun NavBar(
    onHomeNavigation: () -> Unit = {

    },
    onExploreNavigation: () -> Unit = {},
    onBookmarkNavigation: () -> Unit = {},
    currentDestination: NavDestination,
){
    NavigationBar{

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home, contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            selected = currentDestination.hierarchy.any { it.route == Destination.Home.route },
            onClick = onHomeNavigation
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home, contentDescription = "Explore"
                )
            },
            label = { Text("Explore") },
            selected = currentDestination.hierarchy.any { it.route == Destination.Home.route },
            onClick = onHomeNavigation
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home, contentDescription = "Bookmark"
                )
            },
            label = { Text("Bookmark") },
            selected = currentDestination.hierarchy.any { it.route == Destination.Home.route },
            onClick = onHomeNavigation
        )
    }


}

@Preview
@Composable
fun NavBarPreview(){

}