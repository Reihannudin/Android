package com.absence.tablayout


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.absence.tablayout.adaptor.PagerAdaptor
import com.absence.tablayout.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout



class TabLayoutActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)


        //        initialize fragment
        val tabLayoutActivity = HomeFragment()
        val createFragment = CreateFragment()
        val notificationFragment = NotificationFragment()
        val profileFragment =  ProfilesFragment()


        //        make current fragment
        makeCurrentFragment(tabLayoutActivity)

//        make logic bottom navigation
        val buttom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        buttom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_home -> {
                    makeCurrentFragment(tabLayoutActivity)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.ic_create -> {
                    makeCurrentFragment(createFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.ic_notifications -> {
                    makeCurrentFragment(notificationFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.ic_profile -> {
                    makeCurrentFragment(profileFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }


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
}
