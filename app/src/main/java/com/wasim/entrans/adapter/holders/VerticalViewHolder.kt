package com.wasim.entrans.adapter.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wasim.entrans.R
import com.wasim.entrans.data.VerticalItem

class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView = itemView.findViewById<TextView>(R.id.verticalTitle)
    private val descTextView = itemView.findViewById<TextView>(R.id.verticalDesc)
    private val imageView = itemView.findViewById<ImageView>(R.id.verticalImageView)

    fun bindVertical(item: VerticalItem) {
        titleTextView.text = item.title
        descTextView.text = item.desc
        Picasso.get().load(item.image).into(imageView)
    }
}