package com.kenway.movieapp.ui_layer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.kenway.movieapp.model.Movie
import com.kenway.movieapp.navigation.MovieNavigationItem

@Composable
fun MovieListScreen(navHostController: NavHostController,viewModel: MovieViewModel= hiltViewModel())
{
    val result=viewModel.movieList.value

    if(result.isLoading)
    {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            CircularProgressIndicator()
        }
    }

    if(result.error.isNotBlank())
    {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
        {
            Text(text=result.error)
        }
    }

    result.data?.let {
        LazyColumn{
            items(result.data)
            {
                MovieItem(it){
                    navHostController.navigate(MovieNavigationItem.MovieDetails.route+"/$it")
                }

            }
        }
    }

}

@Composable
fun MovieItem(it: Movie,onClick:(String)->Unit) {
        AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.posterPath}", contentDescription =  null,
            modifier = Modifier.
            fillMaxWidth().height(450.dp).padding(vertical = 4.dp).
            clickable {
                onClick.invoke(it.id.toString())
            }, contentScale = ContentScale.FillBounds
        )
}
