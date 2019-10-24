package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class BeenHere(
    @SerializedName("count")
    val count: Int,
    @SerializedName("lastCheckinExpiredAt")
    val lastCheckinExpiredAt: Int,
    @SerializedName("marked")
    val marked: Boolean,
    @SerializedName("unconfirmedCount")
    val unconfirmedCount: Int
)