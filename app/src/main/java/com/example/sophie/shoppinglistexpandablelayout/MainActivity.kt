package com.example.sophie.shoppinglistexpandablelayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    val animals: ArrayList<String> = ArrayList()
    private var myNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItemsToList()

        updateLayout()

        shopping_shoplist_fragment_top_button.setOnClickListener {
            myNumber = myNumber + 4
            updateLayout()
        }


    }

    private fun updateLayout() {
        if (myNumber != 0) {
            // Creates a vertical Layout Manager
            shopping_shoplist_fragment_rw.layoutManager = LinearLayoutManager(this)
            shopping_shoplist_fragment_rw.adapter = MyAdapter(animals, this, myNumber)
            shopping_shoplist_fragment_expanded_layout.visibility = VISIBLE
        } else {
            shopping_shoplist_fragment_expanded_layout.visibility = GONE
        }
    }

    // Adds animals to the empty animals ArrayList
    fun addItemsToList() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")

    }
}
