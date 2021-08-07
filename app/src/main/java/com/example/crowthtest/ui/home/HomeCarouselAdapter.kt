package com.example.crowthtest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crowthtest.R
import com.example.crowthtest.data.CarouselItem
import com.example.crowthtest.databinding.ItemHomeCarouselCardBinding

class HomeCarouselAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<CarouselItem>()

    fun updateData(data: List<CarouselItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CarouselCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_carousel_card, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CarouselCardViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CarouselCardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val vb = ItemHomeCarouselCardBinding.bind(view)

        fun bind() {
        }
    }

}