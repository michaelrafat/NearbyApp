package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Listed(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<GroupXXX>
)