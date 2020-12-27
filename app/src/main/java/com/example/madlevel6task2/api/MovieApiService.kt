package com.example.madlevel6task2.api

import com.example.madlevel6task2.database.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("discover/movie?" +
            "api_key=7d5c4def970e7f89c0b441a107534faf&language=en-US&" +
            "sort_by=popularity.desc&include_adult=false&include_video=false&" +
            "page=1&primary_release_year=2016&with_original_language=en")
    suspend fun getMoviesOfYear(@Query("primary_release_year") year:String):List<Movie>
}