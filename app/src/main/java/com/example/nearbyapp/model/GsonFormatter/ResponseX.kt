package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ResponseX(
    @SerializedName("venue")
    val venue: VenueX
)