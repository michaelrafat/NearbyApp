package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class LikesX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<GroupXXXXXXX>,
    @SerializedName("summary")
    val summary: String
)