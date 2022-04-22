package com.mvvm.Journey

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MenuActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn_order = findViewById<Button>(R.id.btn_order)
        btn_order.setOnClickListener{
            val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)
            val cbCorn = findViewById<CheckBox>(R.id.cbCorn)
            val cbFrenchFries = findViewById<CheckBox>(R.id.cbFrenchFries)
            val cbEgg = findViewById<CheckBox>(R.id.cbEgg)
            val tvOrder = findViewById<TextView>(R.id.tvOrder)

            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val corn = cbCorn.isChecked
            val frenchFries = cbFrenchFries.isChecked
            val egg = cbEgg.isChecked

            val orderString = "Meat: ${meat.text} " +
                    (if(corn) "\nCorn" else "")+
                    (if(frenchFries) "\nfrenchFries" else "")+
                    (if(egg) "\negg" else "")

            tvOrder.text = orderString
        }
    }
}