package com.mvvm.Journey

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpinerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spiner)

        val spMonth = findViewById<Spinner>(R.id.spMonth)

//        define list from activity
        val customList = listOf("Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        val adapter = ArrayAdapter<String>(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, customList)
        spMonth.adapter = adapter

        spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@SpinerActivity,
                    "Selected item is ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}