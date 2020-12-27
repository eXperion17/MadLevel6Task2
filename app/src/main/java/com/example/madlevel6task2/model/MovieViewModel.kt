package com.example.madlevel6task2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.database.Movie
import com.example.madlevel6task2.database.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository =  MovieRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val movies = movieRepository.getMovies(2016)
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun clearMovies() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                movieRepository.clearMovies()
            }
            success.value = true
        }
    }

    fun getMovies(year:Int) : LiveData<List<Movie>> {
        return movieRepository.getMovies(year);
    }
}