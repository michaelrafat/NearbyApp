package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class GroupXXX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<ItemXXX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)