package com.example.switchcheck.adapters.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.switchcheck.R
import com.example.switchcheck.models.Dish
import com.example.switchcheck.models.RailsClickEvent

class DishViewHolder(itemView: View, val onItemClicked: (RailsClickEvent) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val ivDish: ImageView = itemView.findViewById(R.id.iv_dish)
    private val tvDish: TextView = itemView.findViewById(R.id.tv_dish)

    fun bind(dish: Dish) {
        tvDish.text = dish.name

        Glide.with(itemView)
            .load(dish.pictureUrl)
            .into(ivDish)

        itemView.setOnClickListener {
            onItemClicked(RailsClickEvent.DishItemEvent(dish))
        }
    }
}