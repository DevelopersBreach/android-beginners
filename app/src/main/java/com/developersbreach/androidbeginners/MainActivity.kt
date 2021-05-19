package com.developersbreach.androidbeginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.movie_recycler_view)
        val movieList: List<Movie> = MovieRepo.data
        val adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter
    }
}