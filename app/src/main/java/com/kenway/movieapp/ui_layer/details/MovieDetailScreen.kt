package com.kenway.movieapp.ui_layer.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun MovieDetailsScreen(viewModel: MovieDetailViewModel = hiltViewModel()) {


    val result = viewModel.movieDetails.value

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }

    result.data?.let {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${it.posterPath}",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp), contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = it.originalTitle, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = it.tagline, style = MaterialTheme.typography.caption)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.overview, style = MaterialTheme.typography.body1)

        }
    }
}