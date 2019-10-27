package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class SuggestedBounds(
    @SerializedName("ne")
    val ne: NeX,
    @SerializedName("sw")
    val sw: SwX
)