package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class MetaX(
    @SerializedName("code")
    val code: Int,
    @SerializedName("requestId")
    val requestId: String
)