package com.example.madlevel6task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.madlevel5task2.dao.MovieDao
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type;

class MovieRepository(context: Context){
    private val movieDao: MovieDao
    private var currentYear:Int = 0

    private var context: Context

    private val apiUrl:String = "https://api.themoviedb.org/3/discover/movie?" +
            "api_key=7d5c4def970e7f89c0b441a107534faf&language=en-US&" +
            "sort_by=popularity.desc&include_adult=false&include_video=false&" +
            "page=1&primary_release_year=2016&with_original_language=en"

    init {
        val database = MovieRoomDatabase.getDatabase(context)
        movieDao = database!!.movieDao()
        this.context = context
    }

    fun loadMovies(year: Int)/*: LiveData<List<Movie>>*/ {
        //Check if the year is different, if it isn't just return the same
        if (currentYear != year) {
            currentYear = year

            var json:String = ""
            val queue = Volley.newRequestQueue(context)
            val stringRequest = StringRequest(Request.Method.GET, apiUrl,
                Response.Listener<String> { response ->
                    onRequestSuccessful(response)

                },
                Response.ErrorListener {
                    json = "response"
                })

            queue.add(stringRequest)

            //Glide.with(context).load(apiLink).in
            //val movies = parseJSON(json)
            //movieDao.insertMovies(movies);

        }
        //return movieDao.getMovies()
    }

    private fun onRequestSuccessful(json:String) {
        parseJSON(json)

        //val movies = parseJSON(json)
        //movieDao.insertMovies(movies);
    }

    fun getMovies():LiveData<List<Movie>> {
        return movieDao.getMovies()
    }


    suspend fun clearMovies() {
        movieDao.clearMovies()
    }

    // From: https://stackoverflow.com/questions/17037340/converting-jsonarray-to-arraylist and -
    //- adjusted to be in Kotlin
    private fun parseJSON(input:String)/*:List<Movie>*/ {
        val gson = Gson()
        val type: Type = object : TypeToken<List<SimpleMovie?>?>() {}.getType()
        val movies: List<SimpleMovie> = gson.fromJson(input, type)

        val one:String = "hi"
       // return
    }

}