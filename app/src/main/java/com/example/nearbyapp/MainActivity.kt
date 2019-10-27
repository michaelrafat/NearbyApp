package com.example.nearbyapp

import android.Manifest
import android.content.SharedPreferences
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
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nearbyapp.model.Item
import com.example.nearbyapp.model.NearByResponse
import com.example.nearbyapp.viewmodel.PlacesRetrievalViewModel
import android.location.Criteria
import android.widget.*
import com.example.nearbyapp.repoository.Result


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val REALTIME = "Realtime"
    private lateinit var nearbyPlacesRecyclerAdapter: NearbyPlacesRecyclerAdapter
    private lateinit var locationManager: LocationManager
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var switch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MultiDex.install(this)

        checkPermission()
        initView()
        setSwitchOption()
        switchRealtimeLocationOption()
    }

    private fun displayLocations(locationsList: Result<NearByResponse>) {

        val locations: ArrayList<Item> =
            locationsList.data?.response?.groups?.get(0)?.items as ArrayList<Item>

        progressBar.visibility = View.GONE

        nearbyPlacesRecyclerAdapter = NearbyPlacesRecyclerAdapter(this@MainActivity, locations)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = nearbyPlacesRecyclerAdapter
        nearbyPlacesRecyclerAdapter.notifyDataSetChanged()
    }

    private val locationListener: LocationListener = object : LocationListener {

        override fun onLocationChanged(location: Location) {
            getLocations("${location.longitude},${location.latitude})")
            Log.d("MainActivity", "${location.longitude},${location.latitude})")
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

        val permission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission", "Permission denied")
            return
        }
        locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager

        val criteria = Criteria()
        val bestProvider = locationManager.getBestProvider(criteria, true).toString()
        val currentLocation = locationManager.getLastKnownLocation(bestProvider)

        if (currentLocation != null) {
            //Update places
            try {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    60000,
                    500f, // Update after 500 meter
                    this.locationListener
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            locationManager.requestLocationUpdates(bestProvider, 10000, 500f, this.locationListener)
        }
    }

    private fun getLocations(lngLat: String) {

        val viewModel =
            ViewModelProviders.of(this@MainActivity).get(PlacesRetrievalViewModel::class.java)
        viewModel.fetchLocations(lngLat)?.observe(this, Observer<Result<NearByResponse>>
        { resource ->

            if (resource != null) {
                when (resource.status) {
                    Result.Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        val product = resource.data
                        val products = product?.response?.groups?.get(0)?.items?.size
                        if (products != null) {
                            if (products > 0) {
                                constraintLayout.visibility = View.GONE
                                displayLocations(resource)
                            }
                        }
                    }
                    Result.Status.ERROR -> {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        handleEmptyView(0)
                    }
                    Result.Status.LOADING -> {
                        Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
                        handleEmptyView(1)
                    }
                }
            }
        })
    }

    private fun handleEmptyView(responseCode: Int) {

        progressBar.visibility = View.GONE
        constraintLayout.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        if (responseCode == 0) {
            textView.text = "Something went wrong !!"
            imageView.setImageResource(R.drawable.error)
        } else {
            textView.text = "No data found !!"
            imageView.setImageResource(R.drawable.info)
        }
    }

    private fun initView() {

        recyclerView = findViewById(R.id.rv_nearby_locations)
        progressBar = findViewById(R.id.pb_loading)
        textView = findViewById(R.id.tv_message)
        imageView = findViewById(R.id.iv_message)
        constraintLayout = findViewById(R.id.cl_message)
        switch = findViewById(R.id.sw_realtime)
    }

    private fun switchRealtimeLocationOption() {

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                editor.putBoolean(REALTIME, true)
                editor.apply()
                getCurrentLocation()
            } else {
                // The switch is disabled
                editor.putBoolean(REALTIME, false)
                editor.apply()
                recyclerView.adapter = null
                getLocations("40.5145422,30.4454545454")
            }
        }
    }

    private fun checkRealtimeState() : Boolean {

        sharedPreferences = getSharedPreferences(REALTIME, 0)
        editor = sharedPreferences.edit()

        if (sharedPreferences.getBoolean(REALTIME, false)) {
            checkPermission()
            return true
        }
        //First load it gives a fake location data until user check a Realtime option
        getLocations("40.5145422,30.4454545454")
        return false
    }

    private fun setSwitchOption() {
        switch.isChecked = checkRealtimeState()
    }
}