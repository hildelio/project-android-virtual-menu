package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuDishesAdapter
import com.example.trybevirtualmenu.interfaces.MenuDishesItemListener
import com.example.trybevirtualmenu.models.MenuDishesDB

class MainActivity : AppCompatActivity(), MenuDishesItemListener {

    private val menuDishesList: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = MenuDishesDB.findAll()
        val adapter = MenuDishesAdapter(menu)

        adapter.setOnItemListener(this)

        menuDishesList.layoutManager = LinearLayoutManager(baseContext)
        menuDishesList.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("menuDishes_id", position)
        startActivity(it)
    }
}
