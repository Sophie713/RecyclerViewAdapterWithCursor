package com.example.sophie.shoppinglistexpandablelayout

import android.app.Dialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*

//adapter for all shopping lists
class ShoppingShopListAdapter(numberOfItemsToLoad: Int) : RecyclerView.Adapter<ShoppingShopListAdapter.ViewHolder>() {

    private var cursor: Cursor? = null
    private var numberOfItemsToLoad = numberOfItemsToLoad

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    //find all views in the layout of each item
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val shoppingItemName: TextView

        init {
            shoppingItemName = itemView.findViewById(R.id.shopping_shoplist_item_title)
        }
    }

    //setup each item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (cursor == null) {
            return
        }
        try {
            //get id, name, date, item preview, setup progress bar
            cursor!!.moveToPosition(position)
            val shoppingItemName = cursor!!.getInt(cursor!!.getColumnIndex("column name"))


            holder.shoppingItemName.setText(shoppingItemName)

        } catch (e: Exception) {
            Log.e("xyz", e.toString());
        }
    }

    override fun getItemCount(): Int {
        if (cursor != null) {
            return cursor!!.count
        } else {
            return 0
        }
    }

    fun swapCursor(newCursor: Cursor?) {
        if (cursor != null) {
            cursor!!.close()
        }
        cursor = newCursor

        if (newCursor != null) {
            notifyDataSetChanged()
        }

    }
}