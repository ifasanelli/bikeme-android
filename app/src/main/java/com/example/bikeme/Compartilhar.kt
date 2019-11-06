package com.example.bikeme

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_compartilhar.*

class Compartilhar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compartilhar)

        btnCompart.setOnClickListener{
            val s = kms.text.toString()
            val s2 = calorias.text.toString()
            val s3 = "Distância: " + s + ", Calorias: " + s2

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s3)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Dados Fitness")
            startActivity(Intent.createChooser(shareIntent, "BikeMe Fitness"))
        }
    }

    fun voltaHome(v: View){
        val it = Intent(this@Compartilhar, Home::class.java)
        startActivity(it)
    }
}
