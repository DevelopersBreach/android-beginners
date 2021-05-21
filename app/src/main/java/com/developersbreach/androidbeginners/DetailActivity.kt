package com.developersbreach.androidbeginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get the Intent that started this activity and extract the string
        val movieData = intent.getParcelableExtra<Movie>("EXTRA_MESSAGE")
        Log.e("Data", movieData?.title!!)

        // Capture the layout's TextView and set the string as its text
        val detailMovieTextView = findViewById<TextView>(R.id.movie_title_detail_text_view)
        detailMovieTextView.text = movieData.title
    }
}