package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class SourceXX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)