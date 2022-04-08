package com.absence.fragment

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.absence.fragment.ui.main.SectionsPagerAdapter
import com.absence.fragment.databinding.ActivityMainBinding
import com.absence.fragment.databinding.FragmentHomeBinding
import com.absence.fragment.ui.main.PlaceholderFragment
import com.absence.fragment.ui.main.fragment.CreateFragment
import com.absence.fragment.ui.main.fragment.HomeFragment
import com.absence.fragment.ui.main.fragment.NotificationFragment
import com.absence.fragment.ui.main.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initialize fragment
        val homeFragment = HomeFragment()
        val createFragment = CreateFragment()
        val notificationFragment = NotificationFragment()
        val profileFragment = ProfileFragment()

//        make current fragment
        makeCurrentFragment(homeFragment)

//        make logic bottom navigation
        val buttom_navigation = binding.buttomNavigation
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
                R.id.ic_notification -> {
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