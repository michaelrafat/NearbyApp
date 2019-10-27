package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class PageUpdates(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<Any>
)