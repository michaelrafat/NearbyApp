package com.example.nearbyapp.repoository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nearbyapp.Utilities.Constants
import com.example.nearbyapp.api.ApiInterface
import com.example.nearbyapp.model.NearByResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PlaceRepository @Inject constructor(private val api: ApiInterface) {

    private val liveUserResponse: MutableLiveData<Result<NearByResponse>> = MutableLiveData()
    private val mCompositeDisposable = CompositeDisposable()

    fun loadLocations(lngLat: String): MutableLiveData<Result<NearByResponse>>? {

        mCompositeDisposable.add(

            PlaceRepositoryProvider.provideSearchRepository().api.getPlaces(
                lngLat,
                Constants.CLIENT_ID,
                Constants.CLIENT_SECRET,
                Constants.DATE,
                Constants.NEAR,
                Constants.PHOTO
            )
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<NearByResponse>() {
                    override fun onNext(nearByResponse: NearByResponse) {
                        liveUserResponse.value?.data = nearByResponse
                        val size = nearByResponse.response.groups[0].items.size
                        if (size == 0) {
                            liveUserResponse.value =
                                Result.loading(
                                    nearByResponse
                                )
                        } else {
                            liveUserResponse.value =
                                Result.success(
                                    nearByResponse
                                )
                        }
                        Log.d("Response: ", "$size")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MainActivity", e.message)
                        liveUserResponse.value =
                            Result.error("Something went wrong !!")
                    }

                    override fun onComplete() {
                    }
                })
        )
        return liveUserResponse
    }

}