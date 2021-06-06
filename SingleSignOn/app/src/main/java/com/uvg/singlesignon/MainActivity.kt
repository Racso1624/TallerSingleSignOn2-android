package com.uvg.singlesignon

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var iniciar = findViewById<Button>(R.id.btnIniciar)
        iniciar.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            val user = auth.currentUser

            if (user != null){
                Toast.makeText(this,"USER ALREADY LOGGED IN", Toast.LENGTH_SHORT).show()
                val dashboardIntent = Intent(this, MapActivity::class.java)
                startActivity(dashboardIntent)

            } else {
                val signInIntent = Intent(this,SignActivity::class.java)
                startActivity(signInIntent)
            }
        }
    }
}
