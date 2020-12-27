package com.example.madlevel6task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.database.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies:List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(movie: Movie) {
            Glide.with(context).load("https://image.tmdb.org/t/p/original"+movie.poster).into(itemView.iv_poster)
            itemView.tv_rank.text = movie.rating.toString();
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate((R.layout.item_movie), parent, false)
        );
    }


    override fun getItemCount(): Int {
        return movies.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(movies[position])
    }

}