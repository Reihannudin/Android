package com.mvvm.Journey.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mvvm.Journey.R

class BottomNavigationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val homeFragment = FragmentHome()
        val messageFragment = FragmentMessage()
        val profileFragment = FragmentProfile()

        setCurrentFragment(homeFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.bottom_navigation_home -> setCurrentFragment(homeFragment)
                R.id.bottom_navigation_message -> setCurrentFragment(messageFragment)
                R.id.bottom_navigation_profile -> setCurrentFragment(profileFragment)
            }
            true
        }

        bottomNavigation.getOrCreateBadge(R.id.bottom_navigation_message).apply {
            isVisible = true
            number = 10
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment_nav_bottom, fragment)
            commit()
        }
    }
}