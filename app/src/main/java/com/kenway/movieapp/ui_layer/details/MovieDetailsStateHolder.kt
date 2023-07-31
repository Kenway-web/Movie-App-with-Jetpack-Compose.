package com.kenway.movieapp.ui_layer.details

import com.kenway.movieapp.model.details.MovieDetails


data class MovieDetailsStateHolder(
    val isLoading:Boolean= false,
    val data:MovieDetails?=null,
    val error:String=""
)