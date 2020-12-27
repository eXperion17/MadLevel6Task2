package com.example.madlevel6task2.database

import com.google.gson.annotations.SerializedName

data class MovieSearchResult (
    //Named results in an attempt to better parse the data coming from the API
    @SerializedName("results")
    var movies:List<Movie> )

