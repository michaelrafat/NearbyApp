package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("count")
    val count: Int
)