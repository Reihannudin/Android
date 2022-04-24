package com.mvvm.Journey.intents.explicit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class FirstExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_explicit)

        val btn_next1 = findViewById<android.widget.Button>(R.id.btn_explicit_next1)
        btn_next1.setOnClickListener{
            Intent(this, SecondExplicitActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}