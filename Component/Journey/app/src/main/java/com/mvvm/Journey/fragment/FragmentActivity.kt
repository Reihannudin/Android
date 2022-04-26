package com.mvvm.Journey.fragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class FragmentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val firstFragment = Fragment1()
        val secondFragment = Fragment2()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, firstFragment)
            commit()
        }

        val btnFragment1 = findViewById<Button>(R.id.btn_fragment1)
        btnFragment1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, firstFragment)

                commit()
            }
        }

        val btnFragment2 = findViewById<Button>(R.id.btn_fragment2)
        btnFragment2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}