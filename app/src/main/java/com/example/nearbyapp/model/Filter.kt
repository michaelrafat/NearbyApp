package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String
)