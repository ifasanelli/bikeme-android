package com.example.bikeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_informe.*

class Informe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informe)

        btnVlt.setOnClickListener{
            val it = Intent(this, Home::class.java)
            startActivity(it)
        }
    }
}
