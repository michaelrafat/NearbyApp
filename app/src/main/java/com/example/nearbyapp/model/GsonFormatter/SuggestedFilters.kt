package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class SuggestedFilters(
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("header")
    val header: String
)