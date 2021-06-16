package com.developersbreach.androidbeginners.repository.network

import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection

fun createUrl(
    requestUrl: URL?
): String {
    return getResponseFromHttpsUrl(requestUrl)
}

private fun getResponseFromHttpsUrl(
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
        exception.printStackTrace()

    } finally {
        // Stop the url connection (if open)
        urlConnection.disconnect()
    }

    return response
}