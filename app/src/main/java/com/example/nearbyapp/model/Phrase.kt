package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Phrase(
    @SerializedName("count")
    val count: Int,
    @SerializedName("phrase")
    val phrase: String,
    @SerializedName("sample")
    val sample: Sample
)