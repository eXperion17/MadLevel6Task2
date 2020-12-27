package com.example.madlevel6task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.madlevel5task2.dao.MovieDao
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type;

class MovieRepository(context: Context){
    private val movieDao: MovieDao
    private var currentYear:Int = 0

    private lateinit var context: Context

    private val apiLink:String = "https://api.themoviedb.org/3/discover/movie?" +
            "api_key=7d5c4def970e7f89c0b441a107534faf&language=en-US&" +
            "sort_by=popularity.desc&include_adult=false&include_video=false&" +
            "page=1&primary_release_year=2016&with_original_language=en"

    init {
        val database = MovieRoomDatabase.getDatabase(context)
        movieDao = database!!.movieDao()
        this.context = context
    }

    fun getMovies(year: Int): LiveData<List<Movie>> {

        //Check if the year is different, if it isnt just return the same
        if (currentYear != year) {
            currentYear = year

            //val movies = parseJSON(Glide.with(context).load(apiLink).toString())
            //movieDao.insertMovies(movies);

        }
        return movieDao.getMovies()
    }

    suspend fun clearMovies() {
        movieDao.clearMovies()
    }

    // From: https://stackoverflow.com/questions/17037340/converting-jsonarray-to-arraylist and -
    //- adjusted to be in Kotlin
    private fun parseJSON(input:String):List<Movie> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Movie?>?>() {}.getType()
        val movies: List<Movie> = gson.fromJson(input, type)

        return movies
    }

}