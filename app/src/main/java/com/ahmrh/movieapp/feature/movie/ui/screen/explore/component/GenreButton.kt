package com.ahmrh.movieapp.feature.movie.ui.screen.explore.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.feature.movie.domain.entity.Genre

@Composable
fun GenreButton(
    genre: Genre,
    modifier: Modifier = Modifier

){

    TextButton(
        onClick = {},
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
    ) {
        Text(genre.name,
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
@Preview(showBackground = true)
fun GenreButtonPreview() {
    MovieAppTheme {
        GenreButton(genre = Genre.PLACEHOLDER_GENRE)
    }

}