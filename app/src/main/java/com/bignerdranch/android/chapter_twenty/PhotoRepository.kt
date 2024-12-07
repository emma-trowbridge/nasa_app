package com.bignerdranch.android.chapter_twenty

import com.bignerdranch.android.chapter_twenty.api.FlickrApi
import com.bignerdranch.android.chapter_twenty.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class PhotoRepository {

    private val flickrApi:FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        flickrApi = retrofit.create()
    }
//    suspend fun fetchContents() = flickrApi.fetchContents()
//    suspend fun fetchPhotos() = flickrApi.fetchPhotos()
    suspend fun fetchPhotos(date: String): List<GalleryItem> =
    flickrApi.fetchPhotos(date =  date).photos.galleryItems
    // flickrApi.fetchPhotos(date).photos.galleryItems
}