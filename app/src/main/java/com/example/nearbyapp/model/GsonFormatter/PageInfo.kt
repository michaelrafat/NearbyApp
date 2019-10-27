package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("banner")
    val banner: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("links")
    val links: Links
)