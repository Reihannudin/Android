package com.mvvm.Journey

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuBarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menubar)
    }

//    Get the menu view
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navmenu, menu)
        return true
    }

//    make action for menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.icon_add_photo -> {
                Toast.makeText(this, "You clicked on add photo", Toast.LENGTH_SHORT).show()
            }
            R.id.icon_notification -> {
                Toast.makeText(this, "You clicked on notification", Toast.LENGTH_SHORT).show()
            }
            R.id.icon_setting -> {
                Toast.makeText(this, "You clicked on setting", Toast.LENGTH_SHORT).show()
            }
            R.id.icon_feedback -> {
                Toast.makeText(this, "You clicked on feedback", Toast.LENGTH_SHORT).show()
            }
            R.id.icon_close -> {
                finish()
            }

        }
    return true
  }
}