package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("address")
    val address: String,
    @SerializedName("cc")
    val cc: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("crossStreet")
    val crossStreet: String,
    @SerializedName("formattedAddress")
    val formattedAddress: List<String>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("postalCode")
    val postalCode: String,
    @SerializedName("state")
    val state: String
)