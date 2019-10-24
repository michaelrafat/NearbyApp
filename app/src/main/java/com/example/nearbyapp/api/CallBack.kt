package com.example.nearbyapp.api

import com.example.nearbyapp.model.NearByResponse

interface CallBack {

    fun onResponse(nearbyPlace: NearByResponse)
}