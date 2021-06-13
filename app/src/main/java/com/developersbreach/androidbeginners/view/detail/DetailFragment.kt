package com.developersbreach.androidbeginners.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.developersbreach.androidbeginners.Movie
import com.developersbreach.androidbeginners.R

class DetailFragment : Fragment() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = DetailFragmentArgs.fromBundle(requireArguments()).movieArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailTitleTextView = view.findViewById<TextView>(R.id.movie_title_detail_text_view)
        val detailMovieImageView = view.findViewById<ImageView>(R.id.movie_banner_detail_image_view)

        detailTitleTextView.text = movie.title
        Glide.with(requireContext()).load(movie.poster).circleCrop().into(detailMovieImageView)
    }
}
