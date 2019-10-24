package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("geocode")
    val geocode: Geocode,
    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("headerFullLocation")
    val headerFullLocation: String,
    @SerializedName("headerLocation")
    val headerLocation: String,
    @SerializedName("headerLocationGranularity")
    val headerLocationGranularity: String,
    @SerializedName("suggestedBounds")
    val suggestedBounds: SuggestedBounds,
    @SerializedName("suggestedFilters")
    val suggestedFilters: SuggestedFilters,
    @SerializedName("totalResults")
    val totalResults: Int
)