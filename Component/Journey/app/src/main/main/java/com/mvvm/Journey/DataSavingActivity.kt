package com.mvvm.Journey

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_data_saving.*

class DataSavingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_saving)

//        make data can be saved
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

//       make button save
        btn_save.setOnClickListener{
            val name = et_name.text.toString()
            val age = et_age.text.toString().toInt()
            val checkIsAdult = cb_check_adult.isChecked

            editor.apply{
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", checkIsAdult)
            }.apply()
        }

        btn_load.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            et_name.setText(name)
            et_age.setText(age.toString())
            cb_check_adult.isChecked = isAdult
        }
    }
}