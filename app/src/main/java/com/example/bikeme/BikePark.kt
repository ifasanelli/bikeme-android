package com.example.bikeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class BikePark : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_park)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(OnMapReadyCallback {

            googleMap = it
            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(-23.9434,-46.3248)
            googleMap.addMarker(MarkerOptions().position(location1).title("Caloi Loja Oficial"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15f))

            val location2 = LatLng(-23.9449,-46.3265)
            googleMap.addMarker(MarkerOptions().position(location2).title("American Bike"))

            val location3 = LatLng(-23.9424,-46.3281)
            googleMap.addMarker(MarkerOptions().position(location3).title("Santista Bicicletária"))
        })

    }
}
