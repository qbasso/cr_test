package com.example.crowthtest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crowthtest.data.CarouselItem
import com.example.crowthtest.data.FeedItem
import com.example.crowthtest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, {
        })
        with (binding.homeRecycler) {
            val orientation = RecyclerView.VERTICAL
            layoutManager = LinearLayoutManager(context, orientation, false)
            adapter = HomeMainAdapter(this@HomeFragment).apply {
                updateData(mutableListOf<FeedItem>().apply {
                    add(FeedItem.UpperIcons)
                    add(FeedItem.Header)
                    add(FeedItem.CarouselItemList(mutableListOf<CarouselItem>().apply {
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                    }))
                    add(FeedItem.CarouselItemList(mutableListOf<CarouselItem>().apply {
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                    }))
                    add(FeedItem.CarouselItemList(mutableListOf<CarouselItem>().apply {
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                        add(CarouselItem(""))
                    }))
                })
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}