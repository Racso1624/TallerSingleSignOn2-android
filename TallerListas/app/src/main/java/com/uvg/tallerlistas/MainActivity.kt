package com.uvg.tallerlistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    }, {longClickListener -> showItemLongClick(longClickListener)})


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items : MutableList<String> = mutableListOf()

        items.add("Item 1")
        items.add("Item 2")

        btnCrear.setOnClickListener{
            items.add("NUEVO ITEM")
            adaptador.setItems(items)
        }

        adaptador.setItems(items)

        Lista.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        Lista.adapter = adaptador
    }

    private fun showItemClick(position: Int){
        adaptador.removeItem(position)
    }

    private fun showItemLongClick(position: Int){
        adaptador.syncItem(position)
    }
}