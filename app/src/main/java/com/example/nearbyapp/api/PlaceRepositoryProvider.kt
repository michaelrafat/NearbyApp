package com.example.nearbyapp.api

object PlaceRepositoryProvider {

    fun provideSearchRepository(): PlaceRepository {
        return PlaceRepository(ApiInterface.create())
    }

}