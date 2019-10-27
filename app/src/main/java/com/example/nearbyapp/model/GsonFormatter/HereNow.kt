package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class HereNow(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<GroupXX>,
    @SerializedName("summary")
    val summary: String
)