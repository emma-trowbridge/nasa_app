package com.bignerdranch.android.chapter_twenty.api

import com.bignerdranch.android.chapter_twenty.PhotoGalleryFragment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse (
    @Json(name="photo") val galleryItems: List<GalleryItem>
)