package com.example.madlevel6task2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.madlevel6task2.model.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_info.*
import kotlinx.android.synthetic.main.fragment_movie_info.iv_poster
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieInfoFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadMovie(view.context)
    }

    private fun loadMovie(context:Context) {
        var movie = viewModel.movies.value?.get(viewModel.selectedMovie)

        tv_title.text = movie?.title
        tv_rating.text = movie?.rating.toString()
        tv_releasedate.text = movie?.releaseDate
        tv_summary.text = movie?.overview

        Glide.with(context).load("https://image.tmdb.org/t/p/original"+movie?.backdrop).into(iv_cover)
        Glide.with(context).load("https://image.tmdb.org/t/p/original"+movie?.poster).into(iv_poster)

    }

}