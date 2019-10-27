package com.example.nearbyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nearbyapp.api.ApiInterface
import com.example.nearbyapp.repoository.PlaceRepository
import com.example.nearbyapp.repoository.Result
import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.model.PhotoResponse
import javax.inject.Inject

class PlacesRetrievalViewModel : ViewModel() {

    private var mService = PlaceRepository(ApiInterface.create())

    fun fetchLocations(lngLat: String): MutableLiveData<Result<NearByResponse>>? {
        return mService.loadLocations(lngLat)
    }

    fun fetchPhoto(venueId: String): MutableLiveData<PhotoResponse>? {
        return mService.loadPhoto(venueId)
    }

    @Inject
    fun init(repository: PlaceRepository) {
        this.mService = repository
    }
}