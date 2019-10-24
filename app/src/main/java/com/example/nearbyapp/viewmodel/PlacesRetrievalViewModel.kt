package com.example.nearbyapp.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.nearbyapp.api.CallBack
import com.example.nearbyapp.MainActivity
import com.example.nearbyapp.api.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlacesRetrievalViewModel : ViewModel() {

   // private lateinit var venue: NearbyPlace

    fun getLocations(lngLat: String, callBack: CallBack) {

        val service = ApiInterface.Factory.create()

//       service.getPlaces(lngLat)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ result ->
//                callBack?.onResponse(result)
//                Log.d("Result", "There are ${result.response!!.venues?.size} Locations")
//                Toast.makeText(MainActivity(), "Nearby Places", Toast.LENGTH_SHORT).show()
//            }, { error ->
//                error.printStackTrace()
//            })
    }
}