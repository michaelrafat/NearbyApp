package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Timeframe(
    @SerializedName("days")
    val days: String,
    @SerializedName("includesToday")
    val includesToday: Boolean,
    @SerializedName("open")
    val `open`: List<Open>,
    @SerializedName("segments")
    val segments: List<Any>
)