package com.developersbreach.androidbeginners.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String?,
    val poster: String?
) : Parcelable
