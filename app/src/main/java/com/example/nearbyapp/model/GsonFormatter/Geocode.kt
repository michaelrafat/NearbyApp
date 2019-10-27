package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class Geocode(
    @SerializedName("cc")
    val cc: String,
    @SerializedName("center")
    val center: Center,
    @SerializedName("displayString")
    val displayString: String,
    @SerializedName("geometry")
    val geometry: Geometry,
    @SerializedName("longId")
    val longId: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("what")
    val what: String,
    @SerializedName("where")
    val `where`: String
)