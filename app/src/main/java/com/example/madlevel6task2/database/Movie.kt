package com.example.madlevel6task2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("vote_average") var rating: Float,

    @SerializedName("poster_path") var poster: String,
    @SerializedName("backdrop_path") var backdrop: String
)