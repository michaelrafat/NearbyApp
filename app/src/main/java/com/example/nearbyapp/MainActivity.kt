package com.example.nearbyapp

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.adapters.NearbyPlacesRecyclerAdapter
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nearbyapp.model.Item
import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.viewmodel.PlacesRetrievalViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var nearbyPlacesRecyclerAdapter: NearbyPlacesRecyclerAdapter
    private lateinit var locationManager: LocationManager
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MultiDex.install(this)

        recyclerView = findViewById(R.id.rv_nearby_locations)

        //First load it gives a fake location data until user check a Realtime option
        getLocations("40.5,36.4")
        checkPermission()
    }

    private fun displayLocations(locationsList: NearByResponse) {

        val locations: ArrayList<Item> =
            locationsList?.response?.groups?.get(0)?.items as ArrayList<Item>

        nearbyPlacesRecyclerAdapter =
            NearbyPlacesRecyclerAdapter(
                this@MainActivity, locations
            )
        recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = nearbyPlacesRecyclerAdapter
        nearbyPlacesRecyclerAdapter.notifyDataSetChanged()
    }

    private val locationListener: LocationListener = object : LocationListener {

        override fun onLocationChanged(location: Location) {
            getLocations("${location.longitude},${location.latitude})")
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

    private fun getLocations(lngLat: String) {

        val viewModel = ViewModelProviders.of(this).get(PlacesRetrievalViewModel::class.java)
        viewModel.fetchLocations(lngLat)?.observe(this, Observer<NearByResponse>
        { androidList -> displayLocations(androidList) })

    }

}