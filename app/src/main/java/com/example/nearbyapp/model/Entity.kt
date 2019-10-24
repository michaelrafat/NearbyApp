package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Entity(
    @SerializedName("indices")
    val indices: List<Int>,
    @SerializedName("type")
    val type: String
)