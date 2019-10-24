package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("checkinsCount")
    val checkinsCount: Int,
    @SerializedName("tipCount")
    val tipCount: Int,
    @SerializedName("usersCount")
    val usersCount: Int,
    @SerializedName("visitsCount")
    val visitsCount: Int
)