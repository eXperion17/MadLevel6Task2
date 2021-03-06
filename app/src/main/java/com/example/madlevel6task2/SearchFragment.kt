package com.example.madlevel6task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel6task2.database.Movie
import com.example.madlevel6task2.model.MovieViewModel
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SearchFragment : Fragment() {

    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies, :: onMovieClick)

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.bt_search).setOnClickListener {
            viewModel.getMoviesOfYear(et_year.text.toString())
        }

        initViews()
    }

    private fun onMovieClick(position:Int) {
        viewModel.setSelectedMovie(position)

        findNavController().navigate(R.id.movieInfoFragment)
    }

    private fun initViews() {
        rv_movies.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rv_movies.adapter = movieAdapter

        observeChanges()
    }

    private fun observeChanges()  {
        viewModel.movies.observe(viewLifecycleOwner, Observer { movie -> movie?.let {
                movies.clear()
                movies.addAll(movie)
                movieAdapter.notifyDataSetChanged()
            }
        })
    }
}