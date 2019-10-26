package com.example.nearbyapp.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nearbyapp.Utilities.Constants
import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.model.PhotoResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class APiService {

    private val liveUserResponse: MutableLiveData<NearByResponse> = MutableLiveData()
    private val photoUrl: MutableLiveData<PhotoResponse> = MutableLiveData()
    private val mCompositeDisposable = CompositeDisposable()

    fun loadLocations(lngLat: String): MutableLiveData<NearByResponse>? {

        mCompositeDisposable.add(

            PlaceRepositoryProvider.provideSearchRepository().apiService.getPlaces(
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
                        liveUserResponse.value = nearByResponse
                        val size = nearByResponse.response.groups[0].items.size
                        Log.d("Response: ", "$size")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MainActivity", e.message)
                    }

                    override fun onComplete() {
                    }
                })
        )
        return liveUserResponse
    }

    fun loadPhoto(venueId: String): MutableLiveData<PhotoResponse> {

        mCompositeDisposable.add(

            PlaceRepositoryProvider.provideSearchRepository().apiService.getPhoto(
                venueId, Constants.CLIENT_ID
                , Constants.CLIENT_SECRET,
                Constants.DATE,
                Constants.NEAR
            )
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<PhotoResponse>() {
                    override fun onNext(photoResponse: PhotoResponse) {
                        photoUrl?.value = photoResponse
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                    }
                })
        )

        return photoUrl
    }

}