package com.bignerdranch.android.nasa_app.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApodResponse(
    val date: String,
    val explanation: String,
    @Json(name = "hdurl") val hdUrl: String?,
    @Json(name = "media_type") val mediaType: String,
    @Json(name = "serviceVersion") val serviceVersion: String?,
    val title: String,
    val url: String
)