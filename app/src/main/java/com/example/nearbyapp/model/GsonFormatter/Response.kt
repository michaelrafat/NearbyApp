package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Response(

    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("headerFullLocation")
    val headerFullLocation: String,
    @SerializedName("headerLocation")
    val headerLocation: String,
    @SerializedName("headerLocationGranularity")
    val headerLocationGranularity: String,
    @SerializedName("totalResults")
    val totalResults: Int
)