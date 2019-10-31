package com.example.bikeme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_park.*

class Park : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private var location1 = LatLng(-23.943745,-46.325513)
    private var location2 = LatLng(-23.943009, -46.324473)
    private var location3 = LatLng(-23.943921, -46.326162)
    private var location4 = LatLng(-23.940852, -46.325951)
    private var location5 = LatLng(-23.942139, -46.328453)

    private lateinit var mMap: GoogleMap
    private var userL = LatLng(-23.942647,-46.326344)

    override fun onMarkerClick(p0: Marker?): Boolean {
        mMap.clear()
        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Estacionamento Patropi"))
        val m2 = mMap.addMarker(MarkerOptions().position(location2).title("Unipark"))
        val m3 = mMap.addMarker(MarkerOptions().position(location3).title("Estacionamento Green Park"))
        val m4 = mMap.addMarker(MarkerOptions().position(location4).title("Estacionamento Feijó"))
        val m5 = mMap.addMarker(MarkerOptions().position(location5).title("Estacionamento Cavalaro"))

        if(p0?.title== "Estacionamento Patropi"){
            var polyline1 = mMap.addPolyline(
                PolylineOptions()
                    .visible(true)
                    .color(Color.RED)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.943378,-46.326321),
                        LatLng(-23.943599, -46.325484)
                    )
            )
            m1.showInfoWindow()
        }else if(p0?.title == "Unipark"){
            var polyline2 = mMap.addPolyline(
                PolylineOptions()
                    .color(Color.RED)
                    .visible(true)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.943378,-46.326321),
                        LatLng(-23.943489, -46.325181),
                        LatLng(-23.943107, -46.325122),
                        LatLng(-23.943158, -46.324484)
                    )
            )
            m2.showInfoWindow()
        }else if(p0?.title == "Estacionamento Green Park"){
            var polyline3 = mMap.addPolyline(
                PolylineOptions()
                    .color(Color.RED)
                    .visible(true)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.943884, -46.326350)
                    )
            )
            m3.showInfoWindow()
        }else if(p0?.title == "Estacionamento Feijó"){
            var polyline4 = mMap.addPolyline(
                PolylineOptions()
                    .color(Color.RED)
                    .visible(true)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.940852, -46.325951)
                    )
            )
            m4.showInfoWindow()
        }else if(p0?.title == "Estacionamento Cavalaro"){
            var polyline4 = mMap.addPolyline(
                PolylineOptions()
                    .color(Color.RED)
                    .visible(true)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.943378,-46.326321),
                        LatLng(-23.943232, -46.327483),
                        LatLng(-23.942193, -46.327352),
                        LatLng(-23.942092, -46.328347),
                        LatLng(-23.942156, -46.328434)
                    )
            )
            m5.showInfoWindow()
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_park)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnEnviar.setOnClickListener {
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.isMyLocationEnabled = true
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userL, 16.5f))


        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Estacionamento Patropi"))
        val m2 = mMap.addMarker(MarkerOptions().position(location2).title("Unipark"))
        val m3 = mMap.addMarker(MarkerOptions().position(location3).title("Estacionamento Green Park"))
        val m4 = mMap.addMarker(MarkerOptions().position(location4).title("Estacionamento Feijó"))
        val m5 = mMap.addMarker(MarkerOptions().position(location5).title("Estacionamento Cavalaro"))

        mMap.setOnMarkerClickListener(this)
    }
}
