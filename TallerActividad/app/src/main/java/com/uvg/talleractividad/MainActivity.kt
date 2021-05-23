package com.uvg.talleractividad

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuma.setOnClickListener{
            val intent: Intent = Intent(this, Suma::class.java)

            startActivityForResult(intent, 1)
        }

        btnResta.setOnClickListener{
            val intent: Intent = Intent(this, Resta::class.java)

            startActivityForResult(intent, 1)
        }

        btnMultiplicar.setOnClickListener{
            val intent: Intent = Intent(this, Multiplicacion::class.java)

            startActivityForResult(intent, 1)
        }

        btnDividir.setOnClickListener{
            val intent: Intent = Intent(this, Division::class.java)

            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                val bundle = data?.extras
                if(bundle!=null){
                    val resultado = bundle.getString("resultado")
                    txtResultado.text = resultado
                }
            }
        }
    }

}