package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("outsideRadius")
    val outsideRadius: Boolean
)