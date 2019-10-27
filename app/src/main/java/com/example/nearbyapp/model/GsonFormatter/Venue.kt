package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("venuePage")
    val venuePage: VenuePage
)