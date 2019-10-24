package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class CategoryX(
    @SerializedName("icon")
    val icon: IconX,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pluralName")
    val pluralName: String,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("shortName")
    val shortName: String
)