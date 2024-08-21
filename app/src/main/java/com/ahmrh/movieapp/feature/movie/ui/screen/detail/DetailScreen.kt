package com.ahmrh.movieapp.feature.movie.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.ahmrh.movieapp.core.ui.theme.MovieAppTheme
import com.ahmrh.movieapp.core.util.URLUtil
import com.ahmrh.movieapp.feature.movie.domain.entity.Movie
import com.ahmrh.movieapp.feature.movie.ui.component.CircularLoadingBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    movieId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val movie = Movie.PLACEHOLDER_MOVIE

    Scaffold (
        topBar = {

            TopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            /*TODO*/
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ){ innerPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Row {
                SubcomposeAsyncImage(
                    model = URLUtil.imagePathToUrl(movie.imagePath),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(120.dp)
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
                Column {

                    Text(
                        movie.title, style = MaterialTheme.typography.titleLarge, overflow = TextOverflow.Ellipsis, maxLines = 3
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row{

                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text("${movie.vote}/10")
                    }
                }
            }

            Row (
                Modifier.fillMaxWidth()
            ){
                Column (
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "Language", style = MaterialTheme.typography.titleMedium)
                    Text("${movie.language}")

                }
                Column (

                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "Length", style = MaterialTheme.typography.titleMedium)
                    Text(text = "${(movie.runtime ?: 0) / 60} hours")

                }
            }

            Row{

            }

            Column {

                Text(text = "Overview", style = MaterialTheme.typography.titleMedium)
                Text(text = "${movie.overview}", style = MaterialTheme.typography.bodyLarge)
            }


            Column {
                Text(text = "Review", style = MaterialTheme.typography.titleMedium)

            }

        }


    }

}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview(){
    MovieAppTheme {
        DetailScreen(
            55335
        )
    }
}