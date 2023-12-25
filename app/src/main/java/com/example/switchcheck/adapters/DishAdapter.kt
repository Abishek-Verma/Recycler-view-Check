package com.example.switchcheck.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.switchcheck.R
import com.example.switchcheck.adapters.viewholders.DishViewHolder
import com.example.switchcheck.inflate
import com.example.switchcheck.models.Dish
import com.example.switchcheck.models.RailsClickEvent

class DishAdapter(private val onItemClicked: (RailsClickEvent) -> Unit) : RecyclerView.Adapter<DishViewHolder>() {
    var items:List<Dish> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DishViewHolder(parent.inflate(R.layout.item_dish), onItemClicked)

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}