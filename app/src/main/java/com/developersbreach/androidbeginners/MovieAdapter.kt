package com.developersbreach.androidbeginners

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(
    private val movieList: List<Movie>,
    private val clickListener: OnClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val posterImageView: ImageView = itemView.findViewById(R.id.item_movie_poster)

        fun bind(
            movie: Movie,
            clickListener: OnClickListener,
        ) {
            Glide.with(posterImageView.context).load(movie.poster).into(posterImageView)

            posterImageView.setOnClickListener {
                clickListener.onMovieItemClick(movie)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount() = movieList.size

    class OnClickListener(val clickListener: (movie: Movie) -> Unit) {
        fun onMovieItemClick(movie: Movie) {
            clickListener(movie)
        }
    }
}