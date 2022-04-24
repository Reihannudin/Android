package com.mvvm.Journey.intents.explicit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class SecondExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_explicit)

        val btn_next2 = findViewById<Button>(R.id.btn_explicit_next2)
        btn_next2.setOnClickListener{
            startActivity(Intent(this, ThirdExplicitActivity::class.java))
        }

        val btn_back2 = findViewById<Button>(R.id.btn_explicit_back2)
        btn_back2.setOnClickListener{
            finish()
        }
    }
}