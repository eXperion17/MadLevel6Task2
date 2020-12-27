package com.example.madlevel6task2.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.database.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MovieRepository()
    val movies = movieRepository.movies

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getMoviesOfYear(year:String) {
        viewModelScope.launch {
            try {
                movieRepository.getMoviesOfYear(year)
            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
                Log.e("Movie (load) error", error.cause.toString())
            }
        }
    }
}