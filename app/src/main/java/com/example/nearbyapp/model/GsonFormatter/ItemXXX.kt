package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ItemXXX(
    @SerializedName("canonicalUrl")
    val canonicalUrl: String,
    @SerializedName("collaborative")
    val collaborative: Boolean,
    @SerializedName("createdAt")
    val createdAt: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("editable")
    val editable: Boolean,
    @SerializedName("followers")
    val followers: Followers,
    @SerializedName("id")
    val id: String,
    @SerializedName("listItems")
    val listItems: ListItems,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: PhotoX,
    @SerializedName("public")
    val `public`: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("updatedAt")
    val updatedAt: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: UserX
)