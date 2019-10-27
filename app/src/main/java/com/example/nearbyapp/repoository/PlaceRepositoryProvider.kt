package com.example.nearbyapp.repoository

import com.example.nearbyapp.api.ApiInterface

object PlaceRepositoryProvider {

    fun provideSearchRepository(): PlaceRepository {
        return PlaceRepository(ApiInterface.create())
    }

}