package com.mvvm.Journey.parsing

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class SecondParsingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_parsing)
        val tvPerson = findViewById<TextView>(R.id.tv_Person)

        val person = intent.getSerializableExtra("EXTRA_PERSON")as Person
        tvPerson.text = person.toString()
    }
}