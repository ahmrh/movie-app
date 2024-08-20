package com.ahmrh.movieapp.feature.movie.ui.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.core.util.URLUtil
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import com.ahmrh.movieapp.feature.movie.ui.component.CircularLoadingBar

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VerticalMovieListItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {

    Row(
        modifier = modifier
            .height(160.dp)
            .fillMaxWidth()
            .clickable{ onClick() },
    ) {
        SubcomposeAsyncImage(
            model = URLUtil.imagePathToUrl(movie.imagePath),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxHeight()
                .width(120.dp)
                .clip(
                    shape = RoundedCornerShape(8.dp)
                ),

            contentScale = ContentScale.Crop,
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularLoadingBar(
                    modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainer)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        Column(
        ){
            Text(
                movie.title, style = MaterialTheme.typography.titleMedium,
                maxLines = 2, overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(48.dp)
            )

            Row{

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text("${movie.vote}/10")
            }

            FlowRow(
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

            ){
                movie.genre.forEach { genre ->

                    FilterChip(
                        onClick = {},
                        label = {
                            Text(genre.name)
                        },
                        selected = true,
                    )
                }
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun VerticalMovieListItemPreview() {
    MovieAppTheme {
        VerticalMovieListItem(movie = Movie.PLACEHOLDER_MOVIE)
    }
}