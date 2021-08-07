package com.example.crowthtest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crowthtest.databinding.FragmentHomeBinding
import com.example.crowthtest.databinding.ItemHomeHeaderBinding
import com.example.crowthtest.databinding.ItemHomeHeaderCardBinding

class HomeHeaderFragment : Fragment() {

    private var _binding: ItemHomeHeaderCardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemHomeHeaderCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}