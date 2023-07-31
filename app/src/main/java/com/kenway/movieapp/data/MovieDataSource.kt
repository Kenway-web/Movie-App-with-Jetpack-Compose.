package com.kenway.movieapp.data

import com.kenway.movieapp.network.APIService

class MovieDataSource (private val apiService: APIService) {

    suspend fun getMovieList()= apiService.getMMovieList(api_key = "1472958fa1218f657c410b93eede1026")

    suspend fun getMovieDetails(id:String) = apiService.getMovieDetails(id, apikey = "1472958fa1218f657c410b93eede1026")
}