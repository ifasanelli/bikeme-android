package com.example.bikeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_roubo.*

class Roubo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roubo)

        btnVlt.setOnClickListener{
            val it = Intent(this, Home::class.java)
            startActivity(it)
        }

        btnEnviar.setOnClickListener{
            val it = Intent(this, Informe::class.java)
            startActivity(it)
        }

        val edtEnd = findViewById<EditText>(R.id.edtEnd)

        edtEnd?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val endereco = edtEnd?.text.toString().trim()
                btnEnviar?.setEnabled(endereco.isNotEmpty())
            }
        })
    }
}
