package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class PhotoXXX(
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String
)