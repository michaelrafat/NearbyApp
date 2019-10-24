package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Followers(
    @SerializedName("count")
    val count: Int
)