package com.kenway.movieapp.ui_layer.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kenway.movieapp.commmon.Resource
import com.kenway.movieapp.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
        private val movieRepository: MovieRepository,
        savedStateHandle: SavedStateHandle
):ViewModel() {


    val movieDetails =  mutableStateOf(MovieDetailsStateHolder())

    init {
        movieDetails.value= MovieDetailsStateHolder(isLoading = true)

        viewModelScope.launch {
            savedStateHandle.getStateFlow("id","0").collectLatest {
                getMoviesDetails(it)
            }
        }
    }

    fun getMoviesDetails(id:String) = viewModelScope.launch {



        when(    val result=movieRepository.getMovieDetails(id))
        {
            is Resource.Error ->{
                    movieDetails.value= MovieDetailsStateHolder(error=result.message.toString())
            }
            is Resource.Success->{
                    movieDetails.value= MovieDetailsStateHolder(data=result.data)
            }
            else->{

            }
        }


    }

}