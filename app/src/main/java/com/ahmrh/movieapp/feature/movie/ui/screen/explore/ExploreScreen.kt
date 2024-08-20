package com.ahmrh.movieapp.feature.movie.ui.screen.explore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.feature.movie.domain.entity.Genre
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import com.ahmrh.movieapp.feature.movie.ui.component.NavBar
import com.ahmrh.movieapp.feature.movie.ui.screen.explore.component.GenreButton
import com.ahmrh.movieapp.feature.movie.ui.screen.home.component.HorizontalMovieListItem
import com.ahmrh.movieapp.feature.movie.ui.screen.home.component.VerticalMovieListItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navigateToMovie: (Int) -> Unit = {},
    navigateToHome: () -> Unit = {},
    navigateToBookmark: () -> Unit = {},
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Explore movies", style = MaterialTheme.typography.headlineSmall)
                }
            )
        },
        bottomBar = {
            NavBar(
                onHomeNavigation = navigateToHome,
                currentDestination = Destination.Explore
            )
        }
    ) { innerPadding ->

        val listState = rememberLazyListState()

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10){
                    GenreButton(genre = Genre.PLACEHOLDER_GENRE)
                }

            }
            LazyColumn (
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(10){
                    GenreButton(genre = Genre.PLACEHOLDER_GENRE)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){

            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                state = listState
            ){






            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun ExploreScreenPreview(){
    MovieAppTheme {
        ExploreScreen()
    }
}