package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Open(
    @SerializedName("renderedTime")
    val renderedTime: String
)