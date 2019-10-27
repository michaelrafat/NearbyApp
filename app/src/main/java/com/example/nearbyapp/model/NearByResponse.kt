package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class NearByResponse(
    @SerializedName("response")
    val response: Response,
    var responseCode: Int
)