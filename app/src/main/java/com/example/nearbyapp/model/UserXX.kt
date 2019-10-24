package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class UserXX(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("contact")
    val contact: ContactX,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("homeCity")
    val homeCity: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lists")
    val lists: Lists,
    @SerializedName("photo")
    val photo: PhotoXXXX,
    @SerializedName("tips")
    val tips: Tips,
    @SerializedName("type")
    val type: String
)