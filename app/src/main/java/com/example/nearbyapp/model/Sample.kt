package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Sample(
    @SerializedName("entities")
    val entities: List<Entity>,
    @SerializedName("text")
    val text: String
)