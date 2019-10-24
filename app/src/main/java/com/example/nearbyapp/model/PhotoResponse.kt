package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("meta")
    val meta: MetaX,
    @SerializedName("response")
    val response: ResponseX
)