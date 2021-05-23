package com.uvg.talleractividad

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras

        if(bundle != null){
            val resultado = bundle.getString("resultado")
            txtResultado.text = resultado

            btnRegresar.setOnClickListener{
                val intent: Intent = Intent()
                intent.putExtra("resultado1", "Valor desde pantalla 2")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }

    }
}