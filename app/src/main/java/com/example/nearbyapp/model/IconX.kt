package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class IconX(
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String
)