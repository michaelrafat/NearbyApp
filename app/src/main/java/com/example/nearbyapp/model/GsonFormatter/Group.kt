package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)