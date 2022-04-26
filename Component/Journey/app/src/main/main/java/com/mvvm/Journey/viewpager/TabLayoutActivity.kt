package com.mvvm.Journey.viewpager

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mvvm.Journey.R

class TabLayoutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        val images = listOf(
            R.drawable.album_mots_journey,
            R.drawable.album_mots_7,
            R.drawable.album_be,
            R.drawable.album_the_best,
            R.drawable.album_love_yourself,
            R.drawable.album_wings,
            R.drawable.album_face_yourself,
            R.drawable.album_forever_young,
            R.drawable.album_persona
        )

        val adapter = SwipeViewPagerAdaptor(images)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@TabLayoutActivity, "Tab reselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@TabLayoutActivity, "Tab unselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@TabLayoutActivity, "Tab selected", Toast.LENGTH_SHORT).show()
            }
        })
    }
}