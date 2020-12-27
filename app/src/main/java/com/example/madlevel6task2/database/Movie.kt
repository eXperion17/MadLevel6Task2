package com.example.madlevel6task2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movie_table")
data class Movie (
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "releaseDate")
    var releaseDate: Date,
    @ColumnInfo(name = "rating")
    var rating: Number,
    @ColumnInfo(name = "rank")
    var rank: Int,
    @ColumnInfo(name = "summary")
    var summary: String,
    @ColumnInfo(name = "coverImageLink")
    var coverImageLink: String,
    @ColumnInfo(name = "posterImageLink")
    var posterImageLink: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long? = null
)