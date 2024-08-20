package com.ahmrh.movieapp.feature.movie.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.feature.movie.domain.repository.MovieRepository
import com.ahmrh.movieapp.feature.movie.ui.component.NavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToMovie: (Int) -> Unit = {},
    navigateToExplore: () -> Unit = {},
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Movie App", style = MaterialTheme.typography.headlineSmall)
                }
            )
        },
        bottomBar = {
            NavBar(
                onExploreNavigation = navigateToExplore,
                currentDestination = Destination.Home
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ){

            Text(text = "Now Showing", style = MaterialTheme.typography.titleMedium)




        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieAppTheme {
        HomeScreen()
    }

}