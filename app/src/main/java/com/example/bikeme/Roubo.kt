package com.example.bikeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roubo.*

class Roubo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roubo)

        btnVoltar.setOnClickListener{
            val it = Intent(this, Home::class.java)
            startActivity(it)
        }

        btnEnviar.setOnClickListener{
            val it = Intent(this, Informe::class.java)
            startActivity(it)
        }
    }
}
