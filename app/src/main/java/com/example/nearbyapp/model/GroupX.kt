package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class GroupX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<ItemXX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("type")
    val type: String
)