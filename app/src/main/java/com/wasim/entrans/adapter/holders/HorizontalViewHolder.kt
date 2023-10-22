package com.wasim.entrans.adapter.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wasim.entrans.R
import com.wasim.entrans.data.HorizontalItem

class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView = itemView.findViewById<TextView>(R.id.horizontalTitle)
    private val descTextView = itemView.findViewById<TextView>(R.id.horizontalDesc)
    private val imageView = itemView.findViewById<ImageView>(R.id.horizontalImageView)
    private val bigImageView = itemView.findViewById<ImageView>(R.id.horizontalBigImageView)

    fun bindHorizontal(item: HorizontalItem) {
        titleTextView.text = item.title
        descTextView.text = item.desc
        Picasso.get().load(item.image).into(imageView)
        Picasso.get().load(item.image).into(bigImageView)
    }
}