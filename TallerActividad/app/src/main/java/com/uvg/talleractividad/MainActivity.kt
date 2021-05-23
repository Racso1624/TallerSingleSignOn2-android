package com.uvg.talleractividad

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuma.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity2::class.java)

            var numero1: Int = 0
            var numero2: Int = 0
            var resultado:Float = 0f

            val valor1:EditText = findViewById(R.id.valor1)
            val valor2:EditText = findViewById(R.id.valor2)

            val texto1:String = valor1.text.toString()
            val texto2:String = valor2.text.toString()

            try {
                numero1 = texto1.toInt()
                numero2 = texto2.toInt()
            }
            catch (e:InputMismatchException){
                Toast.makeText(this, "Error, Ingrese un Numero", Toast.LENGTH_SHORT).show()
            }

            resultado = (numero1 + numero2).toFloat()

            val textoresultado = resultado.toString()

            intent.putExtra("resultado", textoresultado)

            startActivityForResult(intent, 1)
        }

        btnResta.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity2::class.java)

            var numero1: Int = 0
            var numero2: Int = 0
            var resultado:Float = 0f

            val valor1:EditText = findViewById(R.id.valor1)
            val valor2:EditText = findViewById(R.id.valor2)

            val texto1:String = valor1.text.toString()
            val texto2:String = valor2.text.toString()

            try {
                numero1 = texto1.toInt()
                numero2 = texto2.toInt()
            }
            catch (e:InputMismatchException){
                Toast.makeText(this, "Error, Ingrese un Numero", Toast.LENGTH_SHORT).show()
            }

            resultado = (numero1 - numero2).toFloat()

            val textoresultado = resultado.toString()

            intent.putExtra("resultado", textoresultado)

            startActivityForResult(intent, 1)
        }

        btnMultiplicar.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity2::class.java)

            var numero1: Int = 0
            var numero2: Int = 0
            var resultado:Float = 0f

            val valor1:EditText = findViewById(R.id.valor1)
            val valor2:EditText = findViewById(R.id.valor2)

            val texto1:String = valor1.text.toString()
            val texto2:String = valor2.text.toString()

            try {
                numero1 = texto1.toInt()
                numero2 = texto2.toInt()
            }
            catch (e:InputMismatchException){
                Toast.makeText(this, "Error, Ingrese un Numero", Toast.LENGTH_SHORT).show()
            }

            resultado = (numero1 * numero2).toFloat()

            val textoresultado = resultado.toString()

            intent.putExtra("resultado", textoresultado)

            startActivityForResult(intent, 1)
        }

        btnDividir.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity2::class.java)

            var numero1: Int = 0
            var numero2: Int = 0
            var resultado:Float = 0f

            val valor1:EditText = findViewById(R.id.valor1)
            val valor2:EditText = findViewById(R.id.valor2)

            val texto1:String = valor1.text.toString()
            val texto2:String = valor2.text.toString()

            try {
                numero1 = texto1.toInt()
                numero2 = texto2.toInt()
            }
            catch (e:InputMismatchException){
                Toast.makeText(this, "Error, Ingrese un Numero", Toast.LENGTH_SHORT).show()
            }

            resultado = (numero1 / numero2).toFloat()

            val textoresultado = resultado.toString()

            intent.putExtra("resultado", textoresultado)

            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(resultCode == 1){
                val bundle = data?.extras
                if(bundle != null){
                    val resultado = bundle.getString("resultado1")
                    Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}