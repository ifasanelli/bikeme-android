package com.example.bikeme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun telaShop(v: View){
        val it = Intent(this, BikeShop::class.java)
        startActivity(it)
    }

    fun telaPark(v: View){
        val it = Intent(this, BikePark::class.java)
        startActivity(it)
    }
}