package com.mvvm.Journey.parsing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.Journey.R

class FirstPasingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_parsing)

        val btnApply = findViewById<Button>(R.id.btn_apply)
        btnApply.setOnClickListener{
//            define
            val etName = findViewById<EditText>(R.id.et_name)
            val etAge = findViewById<EditText>(R.id.et_age)
            val etCountry = findViewById<EditText>(R.id.et_country)
//            get data from edit text
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()
//            define data class
            val person = Person(name, age, country)
//            intent to second activity
            Intent(this, SecondParsingActivity::class.java).apply {
                putExtra("EXTRA_PERSON", person)
                startActivity(this)
            }
        }
    }
}