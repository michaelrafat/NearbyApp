package com.example.nearbyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nearbyapp.api.APiService
import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.model.PhotoResponse

class PlacesRetrievalViewModel : ViewModel() {

    private val mService = APiService()

    fun fetchLocations(lngLat: String): MutableLiveData<NearByResponse>? {
        return mService.loadLocations(lngLat)
    }

    fun fetchPhoto(venueId: String): MutableLiveData<PhotoResponse>? {
        return mService.loadPhoto(venueId)
    }

}