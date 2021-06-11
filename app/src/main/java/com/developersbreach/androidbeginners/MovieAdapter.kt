package com.developersbreach.androidbeginners

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class MovieAdapter(
    private val sportsList: List<Movie>,
    private val clickListener: OnClickListener
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class OnClickListener(val clickListener: (movie: Movie) -> Unit) {
        fun onMovieItemClick(movie: Movie) {
            clickListener(movie)
        }
    }

    class MovieViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val card: MaterialCardView = itemView.findViewById(R.id.item_movie_card_view)
        private val title: TextView = itemView.findViewById(R.id.item_movie_title)
        private val overview: TextView = itemView.findViewById(R.id.item_movie_overview)
        private val bannerImageView: ImageView = itemView.findViewById(R.id.item_movie_banner)
        private val itemParent: ConstraintLayout = itemView.findViewById(R.id.item_movie_constraint_layout)

        fun bind(
            movie: Movie,
            clickListener: OnClickListener,
        ) {
            card.setBackgroundResource(movie.background)
            title.text = movie.title
            overview.text = movie.overview

            Glide.with(title.context).load(movie.banner).into(bannerImageView)

            itemParent.setOnClickListener {
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
        val movie: Movie = sportsList[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount() = sportsList.size
}