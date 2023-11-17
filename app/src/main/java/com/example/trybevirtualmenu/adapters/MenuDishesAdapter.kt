package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.MenuDishesItemListener
import com.example.trybevirtualmenu.models.MenuDishes
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuDishesAdapter(private val menuDishes: List<MenuDishes>) :
    Adapter<MenuDishesAdapter.MenuDishesViewHolder>() {
    private var mainActivity: MenuDishesItemListener? = null

    class MenuDishesViewHolder(
        view: View,
        mainActivity: MenuDishesItemListener?
    ) : ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)
        val name: MaterialTextView = view.findViewById(R.id.item_menu_name)

        init {
            view.setOnClickListener { mainActivity?.onItemClick(view, adapterPosition) }
        }
    }

    fun setOnItemListener(mainActivity: MenuDishesItemListener) {
        this.mainActivity = mainActivity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuDishesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_layout, parent, false)
        return MenuDishesViewHolder(view, mainActivity)
    }

    override fun getItemCount(): Int = menuDishes.size

    override fun onBindViewHolder(holder: MenuDishesViewHolder, position: Int) {
        holder.image.setImageResource(menuDishes[position].image)
        holder.name.text = menuDishes[position].name
    }
}
