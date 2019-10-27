package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class TimeframeX(
    @SerializedName("days")
    val days: String,
    @SerializedName("open")
    val `open`: List<OpenX>,
    @SerializedName("segments")
    val segments: List<Any>
)