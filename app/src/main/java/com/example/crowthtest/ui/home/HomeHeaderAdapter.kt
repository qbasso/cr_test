package com.example.crowthtest.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeHeaderAdapter(f: Fragment) : FragmentStateAdapter(f) {

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int) = HomeHeaderFragment()

    companion object {
        const val PAGE_COUNT = 3
    }

}