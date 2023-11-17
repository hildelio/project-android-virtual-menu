package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuDishesAdapter
import com.example.trybevirtualmenu.models.MenuDishesDB

class MainActivity : AppCompatActivity() {

    private val menuDishesList: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = MenuDishesDB.findAll()

        menuDishesList.layoutManager = LinearLayoutManager(baseContext)
        menuDishesList.adapter = MenuDishesAdapter(menu)
    }
}
