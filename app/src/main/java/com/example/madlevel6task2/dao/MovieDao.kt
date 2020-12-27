package com.example.madlevel5task2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel6task2.database.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table ORDER BY rank ASC")
    fun getMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movie_table")
    suspend fun clearMovies()

}