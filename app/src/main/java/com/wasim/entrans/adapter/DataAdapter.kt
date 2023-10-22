package com.wasim.entrans.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wasim.entrans.R
import com.wasim.entrans.adapter.holders.HorizontalViewHolder
import com.wasim.entrans.adapter.holders.ListViewHolder
import com.wasim.entrans.adapter.holders.VerticalViewHolder
import com.wasim.entrans.data.HorizontalItem
import com.wasim.entrans.data.ListItem
import com.wasim.entrans.data.VerticalItem

class DataAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_VERTICAL = 1
    private val TYPE_HORIZONTAL = 2
    private val TYPE_LIST = 3

    private var items: List<Any> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_VERTICAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_vertical, parent, false)
                VerticalViewHolder(view)
            }
            TYPE_HORIZONTAL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_horizontal, parent, false)
                HorizontalViewHolder(view)
            }
            TYPE_LIST -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
                ListViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VerticalViewHolder -> {
                val item = items[position] as VerticalItem
                holder.bindVertical(item)
            }
            is HorizontalViewHolder -> {
                val item = items[position] as HorizontalItem
                holder.bindHorizontal(item)
            }
            is ListViewHolder -> {
                val item = items[position] as ListItem
                holder.bindList(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item) {
            is VerticalItem -> TYPE_VERTICAL
            is HorizontalItem -> TYPE_HORIZONTAL
            is ListItem -> TYPE_LIST
            else -> throw IllegalArgumentException("Invalid data type at position $position")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(newItems: List<Any>) {
        items = newItems
        notifyDataSetChanged()
    }
}
