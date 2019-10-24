package com.example.nearbyapp

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.multidex.MultiDex
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.adapters.NearbyPlacesRecyclerAdapter
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.nearbyapp.api.ApiInterface
import com.example.nearbyapp.model.Item
import com.example.nearbyapp.model.NearByResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private val mCompositeDisposable = CompositeDisposable()
    private lateinit var nearbyPlacesRecyclerAdapter: NearbyPlacesRecyclerAdapter
    private lateinit var locationManager: LocationManager
    private lateinit var recyclerView: RecyclerView
    private val CLIENT_ID: String = "OYOAJQXZDNYHPTYPDDXN3GH4CC4Z35PLWESXDEUCJIZVWCON"
    private val CLIENT_SECRET: String = "TAQJQZAJPSSG2DLBTZMBZRNHKJFKWRR0JGYAGWRBQA20GM4E"
    private val NEAR: String = "cairo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MultiDex.install(this)

        recyclerView = findViewById(R.id.rv_nearby_locations)

//        val viewModel =
//            ViewModelProviders.of(this).get(PlacesRetrievalViewModel::class.java)
//
//        viewModel.getLocations("40.5,36.4", object : CallBack {
//            override fun onResponse(nearbyPlace: NearbyPlace) {
//                displayLocations(nearbyPlace)
//                Log.d("Response", "Near")
//                Toast.makeText(MainActivity(), "Nearby Places", Toast.LENGTH_SHORT).show()
//            }
//        })

        fetchLocations("40.5,36.4")
        checkPermission()
    }

    private fun displayLocations(locationsList: NearByResponse) {

        nearbyPlacesRecyclerAdapter =
            NearbyPlacesRecyclerAdapter(
                this@MainActivity,
                locationsList.response.groups[0].items as ArrayList<Item>
            )
        recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = nearbyPlacesRecyclerAdapter
        nearbyPlacesRecyclerAdapter.notifyDataSetChanged()
    }

    private val locationListener: LocationListener = object : LocationListener {

        override fun onLocationChanged(location: Location) {
            fetchLocations("${location.longitude},${location.latitude})")
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Permission Granted
                //Do your work here
                //Perform operations here only which requires permission
                getCurrentLocation()
            }
        }
    }

    //Check runtime permission
    private fun checkPermission() {

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission already Granted
            //Do your work here
            //Perform operations here only which requires permission
            getCurrentLocation()

        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1
            )
        }
    }

    private fun getCurrentLocation() {

        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission", "Permission denied")
            return
        }

        locationManager = (getSystemService(LOCATION_SERVICE) as LocationManager?)!!
        val currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        if (currentLocation != null) {
            //Update places
            try {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    3000,
                    500f, // Update after 500 meter
                    this.locationListener
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun fetchLocations(lngLat: String) {

        mCompositeDisposable.add(
            ApiInterface.create().getPlaces(lngLat, CLIENT_ID, CLIENT_SECRET, "20191020", NEAR, "1")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<NearByResponse>() {
                    override fun onNext(t: NearByResponse) {

                        val str = t.response.groups[0].items.size
                        displayLocations(t)
                        Toast.makeText(this@MainActivity, "$str", Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MainActivity", e.message)
                    }

                    override fun onComplete() {
                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                        nearbyPlacesRecyclerAdapter.notifyDataSetChanged()
                    }
                })
        )
    }
}