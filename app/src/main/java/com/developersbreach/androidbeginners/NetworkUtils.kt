package com.developersbreach.androidbeginners

import android.util.Log
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

fun createUrl(
    requestUrl: URL?
): String {
    return getResponseFromHttpsUrl(requestUrl)
}

fun getResponseFromHttpsUrl(
    requestUrl: URL?
): String {

    val urlConnection: HttpsURLConnection = requestUrl?.openConnection() as HttpsURLConnection
    var response = ""

    try {
        // Try to connect and read json data

        val inputStream = urlConnection.inputStream
        val scanner = Scanner(inputStream)
        scanner.useDelimiter("\\A")
        if (scanner.hasNext()) {
            response = scanner.next()
        }
        scanner.close()

    } catch (exception: Exception) {
        // If something goes wrong, catch the exception and print it, to solve the error
        // It will not let our app crash
        Log.e("NetworkUtils - HttpsUrl", exception.toString())

    } finally {
        // Stop the url connection (if open)
        urlConnection.disconnect()
    }

    return response
}