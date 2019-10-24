package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("pageInfo")
    val pageInfo: PageInfo,
    @SerializedName("user")
    val user: UserXX
)