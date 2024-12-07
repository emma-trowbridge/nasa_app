package com.bignerdranch.android.chapter_twenty.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrResponse (
    val photos:PhotoResponse
)
