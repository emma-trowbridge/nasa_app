package com.bignerdranch.android.nasa_app

import android.util.Log
import com.bignerdranch.android.nasa_app.api.GalleryItem
import com.bignerdranch.android.nasa_app.api.NasaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val TAG = "PhotoRepository"

class PhotoRepository {

    private val nasaApi: NasaApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")  // Ensure correct base URL for NASA API
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        nasaApi = retrofit.create(NasaApi::class.java)
    }

    suspend fun fetchPhotos(apiKey: String, count: Int): List<GalleryItem> {
        // Fetch the APOD images using the provided API key and count
        val response = nasaApi.fetchApodImages(apiKey = apiKey, count = count)

        Log.d(TAG, "Fetched ${response.size} photos ")

        // Convert the response into GalleryItem objects
        return response.map { apodResponse ->
            GalleryItem(
                title = apodResponse.title,
                url = apodResponse.url,
                date = apodResponse.date,
                explanation = apodResponse.explanation,
                hdurl = apodResponse.hdUrl // Pass hdurl if available, otherwise default to null
            )
        }
    }
}