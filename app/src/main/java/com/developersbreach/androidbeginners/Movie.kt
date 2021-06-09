package com.developersbreach.androidbeginners

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val title: String?,
    val banner: Int,
    val overview: String,
) : Parcelable
