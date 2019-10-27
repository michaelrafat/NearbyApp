package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("photo")
    val photo: PhotoXX,
    @SerializedName("type")
    val type: String
)