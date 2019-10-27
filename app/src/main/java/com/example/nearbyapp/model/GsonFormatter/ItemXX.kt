package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("displayValue")
    val displayValue: String
)