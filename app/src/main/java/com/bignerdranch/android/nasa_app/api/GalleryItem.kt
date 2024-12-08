package com.bignerdranch.android.nasa_app.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    val title: String,
    val url: String,
    val date: String,
    val explanation: String,
    val hdurl: String? = null
)