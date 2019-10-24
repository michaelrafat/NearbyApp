package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("bounds")
    val bounds: Bounds
)