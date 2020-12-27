package com.example.madlevel6task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.dao.MovieDao

class MovieRepository (context: Context){
    private val movieDao: MovieDao
    init {
        val database = MovieRoomDatabase.getDatabase(context)
        movieDao = database!!.movieDao()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movieDao.getMovies()
    }

    suspend fun clearMovies() {
        movieDao.clearMovies()
    }

}