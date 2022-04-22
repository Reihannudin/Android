package com.mvvm.Journey

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val btn_sum = findViewById<Button>(R.id.btn_sum)
        btn_sum.setOnClickListener{
            val firstSumNum = findViewById<EditText>(R.id.et_firstnumber_sum).text.toString().toInt()
            val secondSumNum = findViewById<EditText>(R.id.et_secondnumber_sum).text.toString().toInt()
            val result_sum = firstSumNum + secondSumNum
            val tv_resultSum = findViewById<TextView>(R.id.tv_result_sum)
            tv_resultSum.text = result_sum.toString()
        }

        val btn_sub = findViewById<Button>(R.id.btn_sub)
        btn_sub.setOnClickListener{
            val firstSubNum = findViewById<EditText>(R.id.et_firstnumber_sub).text.toString().toInt()
            val secondSubNum = findViewById<EditText>(R.id.et_secondnumber_sub).text.toString().toInt()
            val result_sub = firstSubNum - secondSubNum
            val tv_resultSub = findViewById<TextView>(R.id.tv_result_sub)
            tv_resultSub.text = result_sub.toString()
        }

        val btn_mul = findViewById<Button>(R.id.btn_mul)
        btn_mul.setOnClickListener{
            val firstMulNum = findViewById<EditText>(R.id.et_firstnumber_mul).text.toString().toInt()
            val secondMulNum = findViewById<EditText>(R.id.et_secondnumber_mul).text.toString().toInt()
            val result_mul = firstMulNum * secondMulNum
            val tv_resultMul = findViewById<TextView>(R.id.tv_result_mul)
            tv_resultMul.text = result_mul.toString()
        }

        val btn_div = findViewById<Button>(R.id.btn_div)
        btn_div.setOnClickListener{
            val firstDivNum = findViewById<EditText>(R.id.et_firstnumber_div).text.toString().toInt()
            val secondDivNum = findViewById<EditText>(R.id.et_secondnumber_div).text.toString().toInt()
            val result_div = firstDivNum / secondDivNum
            val tv_resultDiv = findViewById<TextView>(R.id.tv_result_div)
            tv_resultDiv.text = result_div.toString()
        }
    }
}