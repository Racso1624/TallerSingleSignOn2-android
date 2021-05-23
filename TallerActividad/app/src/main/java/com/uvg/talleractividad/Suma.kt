package com.uvg.talleractividad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.suma.*
import java.lang.Exception


class Suma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.suma)

        btnRegresarsuma.setOnClickListener{
            var numero1:Double = 0.0
            var numero2:Double = 0.0

            val valor1: EditText = findViewById(R.id.valorsuma1)
            val valor2: EditText = findViewById(R.id.valorsuma2)

            val texto1:String = valor1.text.toString()
            val texto2:String = valor2.text.toString()

            try {
                numero1 = texto1.toDouble()
                numero2 = texto2.toDouble()
            }
            catch (e: Exception){
                Toast.makeText(this, "Error, Ingrese un Numero", Toast.LENGTH_SHORT).show()
            }

            val resultado:Double = numero1 + numero2

            val textoResultado:String = resultado.toString()

            val intent: Intent = Intent(this,MainActivity::class.java)
            intent.putExtra("resultado",textoResultado)
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}