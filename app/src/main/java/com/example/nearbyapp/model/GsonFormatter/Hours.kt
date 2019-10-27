package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Hours(
    @SerializedName("isLocalHoliday")
    val isLocalHoliday: Boolean,
    @SerializedName("isOpen")
    val isOpen: Boolean,
    @SerializedName("status")
    val status: String,
    @SerializedName("timeframes")
    val timeframes: List<Timeframe>
)