package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ContactX(
    @SerializedName("facebook")
    val facebook: String,
    @SerializedName("twitter")
    val twitter: String
)