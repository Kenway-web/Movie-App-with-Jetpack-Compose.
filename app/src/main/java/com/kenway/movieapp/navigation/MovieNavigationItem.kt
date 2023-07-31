package com.kenway.movieapp.navigation

sealed  class MovieNavigationItem(val route:String) {

    // 2 objects representing routes
    // route for of string representing Screens

    object MovieList:MovieNavigationItem("movie_list")
    object MovieDetails:MovieNavigationItem("movie_Details")
}