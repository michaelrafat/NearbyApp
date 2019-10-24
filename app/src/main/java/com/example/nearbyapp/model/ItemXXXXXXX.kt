package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class ItemXXXXXXX(
    @SerializedName("agreeCount")
    val agreeCount: Int,
    @SerializedName("authorInteractionType")
    val authorInteractionType: String,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String,
    @SerializedName("createdAt")
    val createdAt: Int,
    @SerializedName("disagreeCount")
    val disagreeCount: Int,
    @SerializedName("editedAt")
    val editedAt: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("likes")
    val likes: LikesX,
    @SerializedName("logView")
    val logView: Boolean,
    @SerializedName("photo")
    val photo: PhotoXXXXX,
    @SerializedName("photourl")
    val photourl: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("todo")
    val todo: Todo,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: UserXXXX
)