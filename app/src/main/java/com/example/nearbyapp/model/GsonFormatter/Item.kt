package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("referralId")
    val referralId: String,
    @SerializedName("venue")
    val venue: Venue
)