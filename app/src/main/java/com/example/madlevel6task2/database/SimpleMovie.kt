package com.example.madlevel6task2.database

class SimpleMovie {

    lateinit var title:String;
    lateinit var overview:String;

    lateinit var backdrop_path:String;
    lateinit var poster_path:String;
    lateinit var date:String;

    lateinit var vote_average:Number;


    fun SimpleMovie(){}

    fun SimpleMovie(title:String, overview:String, backdrop_path:String, poster_path:String, date:String, vote_average:Number) {
        this.title = title
        this.overview = overview
        this.backdrop_path = backdrop_path
        this.poster_path = poster_path
        this.date = date
        this.vote_average = vote_average

    }
}