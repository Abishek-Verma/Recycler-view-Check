package com.example.switchcheck.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.switchcheck.models.RailsItem

abstract class BaseRailsViewHolder<T : RailsItem>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}