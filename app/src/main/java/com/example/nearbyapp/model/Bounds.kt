package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Bounds(
    @SerializedName("ne")
    val ne: Ne,
    @SerializedName("sw")
    val sw: Sw
)