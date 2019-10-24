package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class GroupXXXX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<Any>,
    @SerializedName("type")
    val type: String
)