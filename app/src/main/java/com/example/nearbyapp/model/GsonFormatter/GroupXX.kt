package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class GroupXX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)