package com.developersbreach.androidbeginners.model

import com.developersbreach.androidbeginners.R

data class Sport(
    val icon: Int,
    val title: String
) {
    companion object {

        val sportsList = listOf(
            Sport(R.drawable.ic_baseball, "Baseball"),
            Sport(R.drawable.ic_basketball, "Basketball"),
            Sport(R.drawable.ic_cricket, "Cricket"),
            Sport(R.drawable.ic_esports, "ESports"),
        )
    }
}
