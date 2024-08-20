package com.ahmrh.movieapp.feature.movie.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.ahmrh.movieapp.R
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme

@Composable
fun NavBar(
    onHomeNavigation: () -> Unit = {},
    onExploreNavigation: () -> Unit = {},
    onBookmarkNavigation: () -> Unit = {},
    currentDestination: Destination,
) {
    NavigationBar {

        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (currentDestination == Destination.Home) painterResource(id = R.drawable.filled_home_24)
                    else painterResource(
                        id = R.drawable.outline_home_24
                    ),
                    contentDescription = null
                )
            },
            label = { Text("Home") },
            selected = currentDestination == Destination.Home,
            onClick = onHomeNavigation
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (currentDestination == Destination.Explore) painterResource(id = R.drawable.filled_explore_24)
                    else painterResource(
                        id = R.drawable.outline_explore_24
                    ),
                    contentDescription = null,
                )
            },
            label = { Text("Explore") },
            selected = currentDestination == Destination.Explore,
            onClick = onHomeNavigation
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (currentDestination == Destination.Bookmark) painterResource(id = R.drawable.filled_bookmark_24)
                    else painterResource(
                        id = R.drawable.outline_bookmark_24
                    ),
                    contentDescription = null
                )
            },
            label = { Text("Bookmark") },
            selected = currentDestination == Destination.Bookmark,
            onClick = onHomeNavigation
        )
    }


}

@Preview
@Composable
fun NavBarPreview() {
    MovieAppTheme {
        NavBar(
            currentDestination = Destination.Home
        )
    }

}