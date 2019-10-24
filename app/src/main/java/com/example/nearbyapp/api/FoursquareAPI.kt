package com.example.nearbyapp.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoursquareAPI (private val apiKey: String, private val cacheDuration: Int) {

    val API_URL: String = "https://api.foursquare.com/v2/"

//    object SearchRepositoryProvider {
//        fun provideSearchRepository(): PlaceRepository {
//            return PlaceRepository().apiService
//        }
//    }

}