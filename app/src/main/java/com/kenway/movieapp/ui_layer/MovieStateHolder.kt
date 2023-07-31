package com.kenway.movieapp.ui_layer

import com.kenway.movieapp.model.Movie

data class MovieStateHolder(
    val isLoading:Boolean=false,
    val data:List<Movie>?=null,
    val error:String=""

)
