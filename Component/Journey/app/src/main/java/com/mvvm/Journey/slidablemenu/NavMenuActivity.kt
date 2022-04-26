package com.mvvm.Journey.slidablemenu

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mvvm.Journey.R

class NavMenuActivity: AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_menu)

        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.mi_item1 -> {
                    Toast.makeText(applicationContext,
                        "Item 1", Toast.LENGTH_SHORT).show()
                }
                R.id.mi_item2 -> {
                    Toast.makeText(applicationContext,
                        "Item 2", Toast.LENGTH_SHORT).show()
                }
                R.id.mi_item3 -> {
                    Toast.makeText(applicationContext,
                        "Item 3", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if(toggle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }
