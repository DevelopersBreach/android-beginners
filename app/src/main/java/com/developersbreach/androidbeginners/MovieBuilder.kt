package com.developersbreach.androidbeginners

import org.json.JSONObject
import java.net.URI
import java.net.URL

const val POSTER_APPEND_URL = "https://image.tmdb.org/t/p/w500"

fun buildMovieType(
    movieType: String
): List<Movie> {
    val movieTypeUrl = buildMovieUriType(movieType)
    val url = createUrl(movieTypeUrl)
    return getJsonMovieData(url)
}

fun buildMovieUriType(
    movieType: String
): URL {
    val builtMovieTypeUrl =
        "https://api.themoviedb.org/3/movie/$movieType?api_key="
    val baseUri = URI.create(builtMovieTypeUrl)
    return URL(baseUri.toString())
}

fun getJsonMovieData(
    createUrl: String
): List<Movie> {

    // Empty list of movie objects
    val movieList = ArrayList<Movie>()

    val baseJsonObject = JSONObject(createUrl)
    val resultsArray = baseJsonObject.getJSONArray("results")

    for (i in 0 until resultsArray.length()) {

        val movieJsonObjects = resultsArray.getJSONObject(i)

        val movieTitle = movieJsonObjects.getString("title")
        val posterPath = movieJsonObjects.getString("poster_path")
        val poster = POSTER_APPEND_URL + posterPath

        val movie = Movie(movieTitle, poster)
        movieList.add(movie)
    }

    return movieList
}
