package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class SwX(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)