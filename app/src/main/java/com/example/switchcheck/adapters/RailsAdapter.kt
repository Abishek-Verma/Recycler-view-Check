package com.example.switchcheck.adapters

import android.util.SparseIntArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.switchcheck.R
import com.example.switchcheck.adapters.viewholders.BaseRailsViewHolder
import com.example.switchcheck.adapters.viewholders.RailsListViewHolder
import com.example.switchcheck.adapters.viewholders.RailsTitleViewHolder
import com.example.switchcheck.inflate
import com.example.switchcheck.models.RailsClickEvent
import com.example.switchcheck.models.RailsItem

class RailsAdapter(val onItemClicked: (RailsClickEvent) -> Unit) : RecyclerView.Adapter<BaseRailsViewHolder<RailsItem>>() {

    private val positionList = SparseIntArray()

    var items:List<RailsItem> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(RailsItem.RailsViewType.values()[viewType]) {
        RailsItem.RailsViewType.TITLE -> RailsTitleViewHolder(parent.inflate(R.layout.item_rails_title), onItemClicked)
        RailsItem.RailsViewType.LIST -> RailsListViewHolder(parent.inflate(R.layout.item_rails_list), onItemClicked, ::positionList)
    } as BaseRailsViewHolder<RailsItem>

    override fun onBindViewHolder(holder: BaseRailsViewHolder<RailsItem>, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int) = items[position].type.ordinal

    override fun getItemCount() = items.size

    override fun onViewRecycled(holder: BaseRailsViewHolder<RailsItem>) {
        val innerRecyclerView = (holder as? RailsListViewHolder)?.rvItems
        positionList.put(holder.adapterPosition, innerRecyclerView?.computeHorizontalScrollOffset() ?: 0)
        super.onViewRecycled(holder)
    }
}