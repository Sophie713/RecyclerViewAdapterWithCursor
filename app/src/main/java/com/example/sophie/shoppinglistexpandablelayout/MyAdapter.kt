package com.example.sophie.shoppinglistexpandablelayout

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(animals: ArrayList<String>, context: Context, myNumber: Int) : RecyclerView.Adapter<ViewHolder>() {

    private val items = animals
    private val context = context
    private val myNumber = myNumber
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        if (myNumber < items.size) {
            return myNumber
        } else {
            return items.size
        }
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.tvAnimalType?.text = items.get(position)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvAnimalType = view.findViewById<TextView>(R.id.shopping_shoplist_item_title)
}