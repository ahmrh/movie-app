package com.ahmrh.movieapp.feature.movie.ui.screen.home

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
import com.ahmrh.movieapp.core.ui.navigation.Destination
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import com.ahmrh.movieapp.feature.movie.domain.repository.MovieRepository
import com.ahmrh.movieapp.feature.movie.ui.component.NavBar
import com.ahmrh.movieapp.feature.movie.ui.screen.home.component.HorizontalMovieListItem
import com.ahmrh.movieapp.feature.movie.ui.screen.home.component.VerticalMovieListItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToMovie: (Int) -> Unit = {},
    navigateToExplore: () -> Unit = {},
    navigateToBookmark: () -> Unit = {}

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

        val listState = rememberLazyListState()

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
                item {

                    Text(text = "Now Showing", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))

                }
                item {

                    LazyRow (
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        items(10){

                            HorizontalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        }



                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }


                item {

                    Text(text = "Popular", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {


                    Column(

                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
                    }
                }







            }

            val shouldShowButton = remember {
                derivedStateOf {
                    listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 0
                }
            }
            val coroutineScope = rememberCoroutineScope()

            AnimatedVisibility(
                visible = shouldShowButton.value,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    Text(text = "Scroll to top")
                }
            }
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