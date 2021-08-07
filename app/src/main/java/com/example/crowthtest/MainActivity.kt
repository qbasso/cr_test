package com.example.crowthtest

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.crowthtest.databinding.ActivityMainBinding
import com.example.crowthtest.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = MainPagerAdapter(this)
        with(binding) {
            navView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> viewPager.setCurrentItem(HOME_POSITION, false)
                    else -> {}
                }
                true
            }
        }
        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    internal inner class MainPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun getItemCount() = PAGE_COUNT

        override fun createFragment(position: Int) = HomeFragment()

    }

    companion object {
        const val HOME_POSITION = 0
        const val PAGE_COUNT = 5
    }
}