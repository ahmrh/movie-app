package com.ahmrh.movieapp.feature.movie.ui.screen.home.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie

@Composable
fun HorizontalMovieListItem(
    movie: Movie
){




}

@Composable
@Preview(showBackground = true)
fun HorizontalMovieListItemPreview() {
    MovieAppTheme {
        HorizontalMovieListItem(
            movie = Movie.PLACEHOLDER_MOVIE
        )
    }
}