package com.example.nearbyapp.model


import com.google.gson.annotations.SerializedName

data class VenueX(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("beenHere")
    val beenHere: BeenHere,
    @SerializedName("bestPhoto")
    val bestPhoto: BestPhoto,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String,
    @SerializedName("categories")
    val categories: List<CategoryX>,
    @SerializedName("contact")
    val contact: Contact,
    @SerializedName("createdAt")
    val createdAt: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("hereNow")
    val hereNow: HereNow,
    @SerializedName("hours")
    val hours: Hours,
    @SerializedName("id")
    val id: String,
    @SerializedName("inbox")
    val inbox: Inbox,
    @SerializedName("likes")
    val likes: Likes,
    @SerializedName("listed")
    val listed: Listed,
    @SerializedName("location")
    val location: LocationX,
    @SerializedName("name")
    val name: String,
    @SerializedName("page")
    val page: Page,
    @SerializedName("pageUpdates")
    val pageUpdates: PageUpdates,
    @SerializedName("photos")
    val photos: PhotosX,
    @SerializedName("phrases")
    val phrases: List<Phrase>,
    @SerializedName("popular")
    val popular: Popular,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("ratingColor")
    val ratingColor: String,
    @SerializedName("ratingSignals")
    val ratingSignals: Int,
    @SerializedName("shortUrl")
    val shortUrl: String,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("storeId")
    val storeId: String,
    @SerializedName("timeZone")
    val timeZone: String,
    @SerializedName("tips")
    val tips: TipsX,
    @SerializedName("url")
    val url: String,
    @SerializedName("venueChains")
    val venueChains: List<Any>,
    @SerializedName("verified")
    val verified: Boolean
)