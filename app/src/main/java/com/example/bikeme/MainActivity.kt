package com.example.bikeme

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler= DatabaseHelper(this)

        showHome()

        registration.setOnClickListener(){
            showRegistration()
        }

        login.setOnClickListener(){
            showLogin()
        }

        save.setOnClickListener(){
            handler.insertUserData(name.text.toString(),email.text.toString(),password_registration.text.toString())
            areaUser()
        }

        login_button.setOnClickListener{
            if(handler.userPresent(login_email.text.toString(), login_password.text.toString())){
                Toast.makeText(this,"Logado com sucesso!",Toast.LENGTH_SHORT).show()
                areaUser()
            }else{
                Toast.makeText(this,"Usuário ou senha inválidos",Toast.LENGTH_SHORT).show()
                showLogin()
            }

        }
    }

    private fun areaUser() {
        val it = Intent(this, Home::class.java)
        startActivity(it)
    }

    private fun showRegistration(){
        registration_layout.visibility= View.VISIBLE
        login_layout.visibility= View.GONE
        home_ll.visibility= View.GONE
    }

    private fun showLogin(){
        login_layout.visibility= View.VISIBLE
        registration_layout.visibility= View.GONE
        home_ll.visibility= View.GONE
    }

    private fun showHome(){
        registration_layout.visibility= View.GONE
        login_layout.visibility= View.GONE
        home_ll.visibility= View.VISIBLE
    }
}
