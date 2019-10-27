package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class TipsX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<GroupXXXXXX>
)