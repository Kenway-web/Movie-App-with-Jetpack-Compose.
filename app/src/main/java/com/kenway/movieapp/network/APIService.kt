package com.kenway.movieapp.network

import com.kenway.movieapp.model.MovieListResponse
import com.kenway.movieapp.model.details.MovieDetails
import com.kenway.movieapp.navigation.MovieNavigationItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    //https://api.themoviedb.org/3/movie/{movie_id}?api_key=your_api_key

    @GET("3/movie/popular")
    suspend fun getMMovieList(
        @Query("api_key") api_key:String
    ):MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id:String,
        @Query("api_key")apikey: String
    ): MovieDetails

}