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
import kotlinx.android.synthetic.main.activity_shop.*


class Shop : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private var location1 = LatLng(-23.943005,-46.329077)
    private var location2 = LatLng(-23.944334,-46.320044)
    private var location3 = LatLng(-23.950274,-46.329615)
    private lateinit var mMap: GoogleMap
    private var userL = LatLng(-23.942647,-46.326344)

    override fun onMarkerClick(p0: Marker?): Boolean {
        mMap.clear()
        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Bicicletaria Sonic"))
        val m2 = mMap.addMarker(MarkerOptions().position(location2).title("Rubão Bikes"))
        val m3 = mMap.addMarker(MarkerOptions().position(location3).title("Ney Bikes"))


        if(p0?.title== "Bicicletaria Sonic"){
            var polyline1 = mMap.addPolyline(
                PolylineOptions()
                .visible(true)
                .color(Color.RED)
                .add(
                    LatLng(-23.942669,-46.326229),
                    LatLng(-23.943378,-46.326321),
                    LatLng(-23.943005,-46.329077)
                )
            )
            m1.showInfoWindow()
        }else if(p0?.title == "Rubão Bikes"){
            var polyline2 = mMap.addPolyline(
                PolylineOptions()
                .color(Color.RED)
                .visible(true)
                .add(
                    LatLng(-23.942669,-46.326229),
                    LatLng(-23.943378,-46.326321),
                    LatLng(-23.943823,-46.323056),
                    LatLng(-23.943384,-46.321524),
                    LatLng(-23.943856,-46.321554),
                    LatLng(-23.943953,-46.320158),
                    LatLng(-23.944334,-46.320044)
                )
            )
            m2.showInfoWindow()
        }else if(p0?.title == "Ney Bikes"){
            var polyline3 = mMap.addPolyline(
                PolylineOptions()
                    .color(Color.RED)
                    .visible(true)
                    .add(
                        LatLng(-23.942669,-46.326229),
                        LatLng(-23.949735,-46.327122),
                        LatLng(-23.949444,-46.329459),
                        LatLng(-23.950274,-46.329615)
                    )
            )
            m3.showInfoWindow()
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
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
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userL, 15f))

        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Bicicletaria Sonic"))
        val m2 = mMap.addMarker(MarkerOptions().position(location2).title("Rubão Bikes"))
        val m3 = mMap.addMarker(MarkerOptions().position(location3).title("Ney Bikes"))

        mMap.setOnMarkerClickListener(this)
    }

}
