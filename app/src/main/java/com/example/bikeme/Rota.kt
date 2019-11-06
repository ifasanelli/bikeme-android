package com.example.bikeme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.widget.EditText
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_rota.*


class Rota : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var userL = LatLng(-23.942647,-46.326344)
    private var location1 = LatLng(-23.981256, -46.311546)
    private var center = LatLng(-23.961450, -46.320069)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rota)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val edtLocal = findViewById<EditText>(R.id.txtLocal)
        val btnRota = findViewById<Button>(R.id.btnRota)
        val btnVlt = findViewById<Button>(R.id.btnVlt)
        val safefast = findViewById<Switch>(R.id.safefast)

        edtLocal?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val local = edtLocal?.text.toString().trim()
                btnRota?.setEnabled(local.isNotEmpty())
            }
        })

        btnVlt?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })

        btnRota?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var checa = safefast.isChecked
                if(edtLocal.text.toString() == "fatec"){
                    if(checa){
                        Toast.makeText(this@Rota,"SEGURA!",Toast.LENGTH_SHORT).show()
                        mMap.clear()
                        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Fatec Rubens Lara(antigo endereço)"))
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 13.8f))
                        var polyline1 = mMap.addPolyline(
                            PolylineOptions()
                                .visible(true)
                                .color(Color.RED)
                                .add(
                                    LatLng(-23.942669,-46.326229),
                                    LatLng(-23.943426, -46.326315),
                                    LatLng(-23.943050, -46.329741),
                                    LatLng(-23.943138, -46.329926),
                                    LatLng(-23.945055, -46.330145),
                                    LatLng(-23.951644, -46.330941),
                                    LatLng(-23.959093, -46.331856),
                                    LatLng(-23.964498, -46.332517),
                                    LatLng(-23.966963, -46.332820),
                                    LatLng(-23.967095, -46.332833),
                                    LatLng(-23.967118, -46.332940),
                                    LatLng(-23.967192, -46.333011),
                                    LatLng(-23.967283, -46.333063),
                                    LatLng(-23.967419, -46.333076),
                                    LatLng(-23.967523, -46.333038),
                                    LatLng(-23.967580, -46.332990),
                                    LatLng(-23.967609, -46.332968),
                                    LatLng(-23.967623, -46.332880),
                                    LatLng(-23.968283, -46.332979),
                                    LatLng(-23.969435, -46.333110),
                                    LatLng(-23.969635, -46.333037),
                                    LatLng(-23.969730, -46.333044),
                                    LatLng(-23.969800, -46.333001),
                                    LatLng(-23.970335, -46.331004),
                                    LatLng(-23.971019, -46.328939),
                                    LatLng(-23.971171, -46.328282),
                                    LatLng(-23.972142, -46.325696),
                                    LatLng(-23.972539, -46.324956),
                                    LatLng(-23.972875, -46.324143),
                                    LatLng(-23.973086, -46.323590),
                                    LatLng(-23.973260, -46.323064),
                                    LatLng(-23.974267, -46.321374),
                                    LatLng(-23.974559, -46.321100),
                                    LatLng(-23.974738, -46.320859),
                                    LatLng(-23.975162, -46.320095),
                                    LatLng(-23.975564, -46.319078),
                                    LatLng(-23.977613, -46.316186),
                                    LatLng(-23.980001, -46.313266),
                                    LatLng(-23.981307, -46.311989),
                                    LatLng(-23.981125, -46.311751),
                                    LatLng(-23.981273, -46.311574)
                                )
                        )
                        m1.showInfoWindow()
                    }else{
                        Toast.makeText(this@Rota,"RÁPIDA!",Toast.LENGTH_SHORT).show()
                        mMap.clear()
                        val m1 = mMap.addMarker(MarkerOptions().position(location1).title("Fatec Rubens Lara(antigo endereço)"))
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 13.8f))
                        var polyline1 = mMap.addPolyline(
                            PolylineOptions()
                                .visible(true)
                                .color(Color.RED)
                                .add(
                                    LatLng(-23.942669,-46.326229),
                                    LatLng(-23.943426, -46.326315),
                                    LatLng(-23.943599, -46.325161),
                                    LatLng(-23.957267, -46.326459),
                                    LatLng(-23.957396, -46.326273),
                                    LatLng(-23.957852, -46.321648),
                                    LatLng(-23.961267, -46.316492),
                                    LatLng(-23.964407, -46.311940),
                                    LatLng(-23.964354, -46.311632),
                                    LatLng(-23.964561, -46.311059),
                                    LatLng(-23.964860, -46.310721),
                                    LatLng(-23.965257, -46.310576),
                                    LatLng(-23.968095, -46.306414),
                                    LatLng(-23.968659, -46.306180),
                                    LatLng(-23.971689, -46.310074),
                                    LatLng(-23.975650, -46.313582),
                                    LatLng(-23.978120, -46.315663),
                                    LatLng(-23.980001, -46.313266),
                                    LatLng(-23.981307, -46.311989),
                                    LatLng(-23.981125, -46.311751),
                                    LatLng(-23.981273, -46.311574)
                                )
                        )
                        m1.showInfoWindow()
                    }
                }else{
                    Toast.makeText(this@Rota,"Local não encontrado!",Toast.LENGTH_SHORT).show()
                }
            }

        })


    }



    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.isMyLocationEnabled = true
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userL, 16.5f))

    }
}
