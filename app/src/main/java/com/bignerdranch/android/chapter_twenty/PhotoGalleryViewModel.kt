package com.bignerdranch.android.chapter_twenty

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.chapter_twenty.api.GalleryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

private const val TAG = "PhotoGalleryViewModel"

class PhotoGalleryViewModel : ViewModel(){

    private val photoRepository = PhotoRepository()

    private val _galleryItems: MutableStateFlow<List<GalleryItem>> =
        MutableStateFlow(emptyList())

    val galleryItems: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {
            val randomDate = generateRandomDate()
            try {
                val items = photoRepository.fetchPhotos(randomDate)
                Log.d(TAG, "Items Received for date: $randomDate")
                //fetches photos by passing the random date to PhotoRepository.fetchPhotos(Date)
                _galleryItems.value = items
            }catch (ex:Exception){

                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
    //generates random date between start date and current date
    private fun generateRandomDate(): String {
        val startDate = LocalDate.of(2005, 6, 1)
        val endDate = LocalDate.now()
        val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
        val randomDays = Random.nextLong(daysBetween + 1)
        val randomDate = startDate.plusDays(randomDays)
        return randomDate.toString()
        //randomDate.toString() converts the LocalDate object into a string representation in the format YYYY-MM-DD
    }

}