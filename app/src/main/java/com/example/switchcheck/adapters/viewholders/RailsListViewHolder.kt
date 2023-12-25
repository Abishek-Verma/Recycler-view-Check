package com.example.switchcheck.adapters.viewholders

import android.util.SparseIntArray
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.switchcheck.R
import com.example.switchcheck.adapters.DishAdapter
import com.example.switchcheck.models.RailsClickEvent
import com.example.switchcheck.models.RailsItem

class RailsListViewHolder(
    view: View,
    val onItemClicked: (RailsClickEvent) -> Unit,
    val positionList: () -> SparseIntArray
) : BaseRailsViewHolder<RailsItem.RailsList>(view) {

    val rvItems: RecyclerView by lazy { view.findViewById<RecyclerView>(R.id.rv_rails_list) }

    override fun bind(item: RailsItem.RailsList) {
        val adapter = DishAdapter(onItemClicked)
        rvItems.adapter = adapter
        adapter.items = item.items

        // Retrieve and set the saved position
        val offset = positionList().get(adapterPosition, 0)
        (rvItems.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset (0, -offset)
    }
}