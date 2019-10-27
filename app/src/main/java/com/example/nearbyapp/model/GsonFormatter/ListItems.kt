package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ListItems(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<ItemXXXX>
)