package com.example.madlevel6task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.madlevel6task2.api.MovieApi
import com.example.madlevel6task2.api.MovieApiService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.withTimeout
import java.lang.reflect.Type;

class MovieRepository() {
    private val movieApiService: MovieApiService = MovieApi.createApi()
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMoviesOfYear(year:String)  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMoviesOfYear(year)
            }

            _movies.value = result
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to load movies!", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

}