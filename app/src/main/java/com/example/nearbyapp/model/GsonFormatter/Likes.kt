package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("count")
    val count: Int,
    @SerializedName("summary")
    val summary: String
)