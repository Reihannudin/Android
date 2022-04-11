package com.absence.tablayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.absence.tablayout.R
import com.absence.tablayout.adaptor.PagerAdaptor
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout


class PagerFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //        Define tab layout
        val tabLayout = view.findViewById<TabLayout>(R.id.tabBar)
        val tabAttendance = view.findViewById<TabItem>(R.id.tabAttendance)
        val tabMyAttendance = view.findViewById<TabItem>(R.id.tabMyAttendance)

//        Define View Pager
        val viewPager = view.findViewById<ViewPager>(R.id.viewPagerHome)

//        Set adaptor to view pager
        val pagerAdapter: PagerAdapter = PagerAdaptor(
            activity?.supportFragmentManager ?: return,
            tabLayout.tabCount
        )

        //        set adapter to view pager
        viewPager.adapter = pagerAdapter

//        change tab view when the tab is selected or clicked
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })
    }
}

