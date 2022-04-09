package com.absence.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.absence.tablayout.adaptor.PagerAdaptor
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout



class TabLayoutActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)


//        Define tab layout
        val tabLayout = findViewById<TabLayout>(R.id.tabBar)
        val tabAttendance = findViewById<TabItem>(R.id.tabAttendance)
        val tabMyAttendance = findViewById<TabItem>(R.id.tabMyAttendance)

//        Define View Pager
        val viewPager = findViewById<ViewPager>(R.id.viewPagerHome)

//        Set adaptor to view pager
        val pagerAdapter: PagerAdapter = PagerAdaptor(
            supportFragmentManager,
            tabLayout.tabCount
        )


//        set adapter to view pager
        viewPager.adapter = pagerAdapter

//        change tab view when the tab is selected or clicked
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })
    }
}

