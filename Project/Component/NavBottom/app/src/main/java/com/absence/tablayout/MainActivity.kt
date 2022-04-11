package com.absence.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.absence.tablayout.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initialize fragment
        val homeFragment= HomeFragment()
        val createFragment = CreateFragment()
        val notificationFragment = NotificationFragment()
        val profileFragment =  ProfilesFragment()

//        make current fragment
        makeCurrentFragment(homeFragment)

//        make logic bottom navigation
        val buttom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        buttom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_home -> {
                    makeCurrentFragment(homeFragment)
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
}
