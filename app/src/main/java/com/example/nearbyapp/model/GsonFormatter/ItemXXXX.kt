package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ItemXXXX(
    @SerializedName("createdAt")
    val createdAt: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("photo")
    val photo: Photo
)