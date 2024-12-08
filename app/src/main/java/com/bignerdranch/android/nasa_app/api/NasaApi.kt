package com.bignerdranch.android.nasa_app.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "WZLfsRF0TBvwQkWazV5GY3YePQh1Id0mfrBxsN9E"

interface NasaApi {

@GET("planetary/apod")
    suspend fun fetchApodImages(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("count") count: Int = 50
    ): List<ApodResponse>
}