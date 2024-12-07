package com.bignerdranch.android.chapter_twenty.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "638a51c66d2f9edec8dd4f91656eb562"

interface FlickrApi {

//    @GET("/")
//    suspend fun fetchContents(): String

    @GET("services/rest/")
    suspend fun fetchPhotos(
        @Query("method") method: String = "flickr.interestingness.getList",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("extras") extras: String = "url_s",
        @Query("date") date: String //added parameter 1b
    ): FlickrResponse


}