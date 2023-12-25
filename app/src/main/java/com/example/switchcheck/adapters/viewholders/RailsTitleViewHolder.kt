package com.example.switchcheck.adapters.viewholders

import android.view.View
import android.widget.TextView
import com.example.switchcheck.R
import com.example.switchcheck.adapters.viewholders.BaseRailsViewHolder
import com.example.switchcheck.models.RailsClickEvent
import com.example.switchcheck.models.RailsItem

class RailsTitleViewHolder(view: View, val onItemClicked: (RailsClickEvent) -> Unit) : BaseRailsViewHolder<RailsItem.RailsTitle>(view) {
    private val tvTitle by lazy { view.findViewById<TextView>(R.id.tv_rails_title) }

    override fun bind(item: RailsItem.RailsTitle) {
        tvTitle.text = item.title

        itemView.setOnClickListener {
            onItemClicked(RailsClickEvent.TitleItemEvent(item))
        }
    }
}