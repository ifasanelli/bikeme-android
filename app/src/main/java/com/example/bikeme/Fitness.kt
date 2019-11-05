package com.example.bikeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class Fitness : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var chronometer: Chronometer
    private var isPlaying: Boolean = false
    private var pauseOffset: Long = 0
    private var userL = LatLng(-23.942647,-46.326344)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        chronometer = findViewById(R.id.chronometer)

        val chronometer = findViewById<Chronometer>(R.id.chronometer)

        val button = findViewById<Button>(R.id.btnStart)
        button?.setOnClickListener(object : View.OnClickListener {



            override fun onClick(v: View) {
                if (!isPlaying) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset)
                    chronometer.start()
                    isPlaying = true
                } else {
                    chronometer.stop()
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase()
                    isPlaying = false
                }

                button.setText(if (!isPlaying) R.string.start else R.string.stop)
                Toast.makeText(this@Fitness, getString(if (isPlaying) R.string.playing else R.string.stopped), Toast.LENGTH_SHORT).show()
            }
        })

        val button2 = findViewById<Button>(R.id.btnReset)
        button2?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (!isPlaying) {
                    chronometer.setBase(SystemClock.elapsedRealtime())
                    pauseOffset = 0
                }else{
                    Toast.makeText(this@Fitness,"O cronômetro deve ser parado primeiro!",Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    fun voltarHome(v:View){
        finish()
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.isMyLocationEnabled = true
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userL, 16.5f))
    }
}
