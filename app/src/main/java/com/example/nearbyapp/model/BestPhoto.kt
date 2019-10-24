package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class BestPhoto(
    @SerializedName("createdAt")
    val createdAt: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("suffix")
    val suffix: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("width")
    val width: Int
)