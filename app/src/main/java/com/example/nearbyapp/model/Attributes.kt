package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("groups")
    val groups: List<GroupX>
)