package com.mvvm.Journey.intents.explicit

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class ThirdExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_explicit)

        val btn_back3 = findViewById<Button>(R.id.btn_explicit_back3)
        btn_back3.setOnClickListener {
            finish()
        }
    }
}