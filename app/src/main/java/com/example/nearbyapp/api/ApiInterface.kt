package com.example.nearbyapp.api

import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.model.PhotoResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("venues/explore/")
    fun getPlaces(
        @Query("ll") lngLat: String
        , @Query("client_id") clientId: String
        , @Query("client_secret") clientSecret: String
        , @Query("v") date: String
        , @Query("near") near: String
        , @Query("venuePhotos") photo: String
    ): Observable<NearByResponse>

    @GET("venues/{VENUE_ID}/")
    fun getPhoto(
        @Path("VENUE_ID") VENUE_ID: String
        , @Query("client_id") clientId: String
        , @Query("client_secret") clientSecret: String
        , @Query("v") date: String
        , @Query("near") near: String

    ): Observable<PhotoResponse>

    companion object Factory {

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.foursquare.com/v2/")
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}