package udemy.course.summary.android.app.bindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityMainFirstBindBinding
import kotlin.properties.Delegates

class MainFirstBindActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainFirstBindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_first_bind)

        binding.btnCountCalculatorCaloriesCalculate.setOnClickListener {
            countCalories()
        }
    }

    private fun countCalories(){


        val weight = binding.etCalculatorCaloriesWeight.text.toString().toDouble()
        val height = binding.etCalculatorCaloriesHeight.text.toString().toDouble()
        val age = binding.etCalculatorCaloriesAge.text.toString().toInt()

        val weightStr = weight.toString()
        val heightStr = height.toString()
        val ageStr = age.toString()

        if(weight == 0.0 || height == 0.0|| age == 0 ){
            binding.tvCalculatorCaloriesResultDesc.text = "Please fill all fields"
        }else if(weightStr.isBlank() || heightStr.isBlank() || ageStr.isBlank()){
            binding.tvCalculatorCaloriesResultDesc.text = "Please all fields"
        } else {
            val bmr = (88.4 + 13.4 * weight) + (4.8 * height) - (5.68 * age)
            binding.tvCalculatorCaloriesResultDesc.text = "Your average daily calorie is $bmr kkal"
        }
    }
}