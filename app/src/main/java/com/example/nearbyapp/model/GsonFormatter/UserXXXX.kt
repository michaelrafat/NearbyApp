package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class UserXXXX(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("photo")
    val photo: PhotoXXXXXX,
    @SerializedName("type")
    val type: String
)