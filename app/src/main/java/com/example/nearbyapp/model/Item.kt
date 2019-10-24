package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("reasons")
    val reasons: Reasons,
    @SerializedName("referralId")
    val referralId: String,
    @SerializedName("venue")
    val venue: Venue
)