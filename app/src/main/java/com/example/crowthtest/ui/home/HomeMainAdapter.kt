package com.example.crowthtest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.crowthtest.R
import com.example.crowthtest.data.FeedItem
import com.example.crowthtest.databinding.ItemHomeCarouselBinding
import com.example.crowthtest.databinding.ItemHomeHeaderBinding
import com.example.crowthtest.databinding.ItemUpperIconsBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.roundToInt

class HomeMainAdapter(private val fragment: Fragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<FeedItem>()

    fun updateData(data: List<FeedItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_header, parent, false))
            }
            VIEW_TYPE_ICONS -> {
                UpperIconsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_upper_icons, parent, false))
            }
            else -> {
                CarouselItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_carousel, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].let {
            when (holder.itemViewType) {
                VIEW_TYPE_HEADER -> (holder as HeaderViewHolder).bind()
                VIEW_TYPE_ICONS -> (holder as UpperIconsViewHolder).bind()
                else -> (holder as? CarouselItemViewHolder)?.bind(it as FeedItem.CarouselItemList)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int) = when (items[position]) {
        is FeedItem.Header -> VIEW_TYPE_HEADER
        is FeedItem.UpperIcons -> VIEW_TYPE_ICONS
        else -> VIEW_TYPE_CAROUSEL
    }

    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val vb = ItemHomeHeaderBinding.bind(view)

        fun bind() {
            with (vb.headerPager) {
                clipToPadding = false
                setPadding(resources.getDimension(R.dimen.padding_small).roundToInt(), 0, resources.getDimension(R.dimen.padding_small).roundToInt(), 0)
                setPageTransformer(MarginPageTransformer(resources.getDimension(R.dimen.margin_small).roundToInt()))
                adapter = HomeHeaderAdapter(fragment)
                TabLayoutMediator(vb.tabLayout, this) { tab, position ->
                }.attach()
            }
        }

    }

    inner class UpperIconsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val vb = ItemUpperIconsBinding.bind(view)

        fun bind() {
        }

    }

    inner class CarouselItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val vb = ItemHomeCarouselBinding.bind(view)

        fun bind(carouselItemList: FeedItem.CarouselItemList) {
            with(vb.horizontalList) {
                val orientation = RecyclerView.HORIZONTAL
                layoutManager = LinearLayoutManager(view.context, orientation, false)
                adapter = HomeCarouselAdapter().apply {
                    updateData(carouselItemList.items)
                }
            }
        }
    }

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ICONS = 1
        const val VIEW_TYPE_CAROUSEL = 2
    }
}