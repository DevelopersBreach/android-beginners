package com.developersbreach.androidbeginners.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.androidbeginners.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popularRecyclerView: RecyclerView = view.findViewById(R.id.popular_movies_recycler_view)
        val topRatedRecyclerView: RecyclerView =
            view.findViewById(R.id.top_rated_movies_recycler_view)

        val progressPopularMovies: ProgressBar = view.findViewById(R.id.progress_popular_movies)
        val progressTopRatedMovies: ProgressBar = view.findViewById(R.id.progress_top_rated_movies)

        progressPopularMovies.visibility = View.VISIBLE
        progressTopRatedMovies.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val movieList = getMoviesList("popular")
            val adapter = MovieAdapter(movieList, listener)
            popularRecyclerView.adapter = adapter
            progressPopularMovies.visibility = View.INVISIBLE
        }

        viewLifecycleOwner.lifecycleScope.launch {
            val movieList = getMoviesList("top_rated")
            val adapter = MovieAdapter(movieList, listener)
            topRatedRecyclerView.adapter = adapter
            progressTopRatedMovies.visibility = View.INVISIBLE
        }
    }

    private suspend fun getMoviesList(
        movieType: String
    ): List<Movie> {
        var movieList: List<Movie>
        withContext(Dispatchers.Default) {
            movieList = buildMovieType(movieType)
        }
        return movieList
    }

    private val listener = MovieAdapter.OnClickListener { movie ->
        findNavController().navigate(
            ListFragmentDirections.listToDetailFragment(movie)
        )
    }
}