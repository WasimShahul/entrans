package com.wasim.entrans.adapter.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wasim.entrans.R
import com.wasim.entrans.data.ListItem

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView = itemView.findViewById<TextView>(R.id.listTitle)
    private val descTextView = itemView.findViewById<TextView>(R.id.listDesc)
    private val imageView = itemView.findViewById<ImageView>(R.id.listImageView)

    fun bindList(item: ListItem) {
        titleTextView.text = item.title
        descTextView.text = item.desc
        Picasso.get().load(item.image).into(imageView)
    }
}