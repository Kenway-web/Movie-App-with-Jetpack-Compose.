package com.kenway.movieapp.di

import com.kenway.movieapp.data.MovieDataSource
import com.kenway.movieapp.data.MovieRepository
import com.kenway.movieapp.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/").
        addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Provides
    fun provideApiService(retrofit: Retrofit):APIService{
        return  retrofit.create(APIService::class.java)
    }

    @Provides
    fun provideDataSource(apiService: APIService):MovieDataSource{
        return MovieDataSource(apiService)
    }

    @Provides
    fun provideMovieRepository(dataSource: MovieDataSource):MovieRepository{
        return MovieRepository(dataSource)
    }


}