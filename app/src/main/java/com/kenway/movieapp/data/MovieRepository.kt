package com.kenway.movieapp.data

import com.kenway.movieapp.commmon.Resource
import com.kenway.movieapp.model.Movie
import com.kenway.movieapp.model.details.MovieDetails
import com.kenway.movieapp.navigation.MovieNavigationItem

class MovieRepository(private val movieDataSource: MovieDataSource) {


    suspend fun getMMovieList(): Resource<List<Movie>>{

       return try {
            Resource.Success(data=movieDataSource.getMovieList().results)
              }
        catch (e:Exception)
        {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getMovieDetails(id:String):Resource<MovieDetails>{
        return try {
            Resource.Success(data = movieDataSource.getMovieDetails(id))
        }
        catch (e:Exception)
        {
            Resource.Error(e.message.toString())
        }
    }

}