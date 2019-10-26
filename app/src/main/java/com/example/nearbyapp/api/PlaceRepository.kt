package com.example.nearbyapp.api

import com.example.nearbyapp.Utilities.Constants
import com.example.nearbyapp.model.NearByResponse
import io.reactivex.Observable

class PlaceRepository(val apiService: ApiInterface) {

    fun exploreLocations(location: String): Observable<NearByResponse> {

        return apiService.getPlaces(
            location, Constants.CLIENT_ID,
            Constants.CLIENT_SECRET,
            Constants.DATE,
            Constants.NEAR,
            Constants.PHOTO
        )
    }

}