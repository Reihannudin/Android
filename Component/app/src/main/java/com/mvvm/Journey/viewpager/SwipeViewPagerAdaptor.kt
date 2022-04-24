package com.mvvm.Journey.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.Journey.R

class SwipeViewPagerAdaptor(val images: List<Int>) :
    RecyclerView.Adapter<SwipeViewPagerAdaptor.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_swipe_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val ivImage = holder.itemView.findViewById<ImageView>(R.id.iv_Image)
        val curlImage = images[position]
        ivImage.setImageResource(curlImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}