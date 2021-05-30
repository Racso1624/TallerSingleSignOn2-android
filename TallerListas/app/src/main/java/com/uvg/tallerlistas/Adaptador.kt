package com.uvg.tallerlistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class Adaptador(private val clickListener: (Int) -> Unit, private val longClickListener: (Int) -> Unit): RecyclerView.Adapter<Adaptador.ItemViewHolder>() {

    private var items: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, clickListener, longClickListener)
    }

    fun setItems(nuevosItems: MutableList<String>){
        this.items = nuevosItems
        notifyDataSetChanged()
    }

    fun getItem(position: Int) : String{
        return items[position]
    }

    fun removeItem(position: Int){
        items.removeAt(position)
        setItems(items)
    }

    fun syncItem(position: Int){
        items[position] = "ITEM MODIFICADO"
        setItems(items)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: String, listener: (Int) -> Unit, longClickListener: (Int) -> Unit) = with(itemView){
            txtTitulo.text = item
            setOnClickListener{ listener(adapterPosition) }
            setOnLongClickListener{
                longClickListener(adapterPosition)
                true
            }
        }
    }

}
