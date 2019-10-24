package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class PhotosX(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<GroupXXXXX>
)