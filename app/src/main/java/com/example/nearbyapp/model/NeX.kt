package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class NeX(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)