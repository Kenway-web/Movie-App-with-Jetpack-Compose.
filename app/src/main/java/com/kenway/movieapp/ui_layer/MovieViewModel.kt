package com.kenway.movieapp.ui_layer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kenway.movieapp.commmon.Resource
import com.kenway.movieapp.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository:MovieRepository):ViewModel() {


    val movieList= mutableStateOf(MovieStateHolder())

    init {
        movieList.value= MovieStateHolder(isLoading = true)
        getMovieList()
    }

     fun getMovieList()=viewModelScope.launch(Dispatchers.IO) {

        when(val result=movieRepository.getMMovieList())
        {
            is Resource.Success->{
                movieList.value = MovieStateHolder(data = result.data)
            }
            is Resource.Error->{
                movieList.value = MovieStateHolder(error = result.message.toString())
            }
            else->{

            }

        }

    }
}