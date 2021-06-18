package com.developersbreach.androidbeginners.utils

import com.developersbreach.androidbeginners.R

val sportsList = listOf(
    "Baseball",
    "Basketball",
    "Cricket",
    "ESports",
)

fun getSportImage(
    selectedSport: String
): Int {

    return when (selectedSport) {
        "Baseball" -> return R.drawable.ic_baseball
        "Basketball" -> return R.drawable.ic_basketball
        "Cricket" -> return R.drawable.ic_cricket
        "ESports" -> return R.drawable.ic_esports
        else -> 0
    }
}