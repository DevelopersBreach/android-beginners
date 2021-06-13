package com.developersbreach.androidbeginners

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String?,
    val poster: String?
) : Parcelable
