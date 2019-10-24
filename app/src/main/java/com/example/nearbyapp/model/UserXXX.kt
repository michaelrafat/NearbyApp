package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class UserXXX(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String
)