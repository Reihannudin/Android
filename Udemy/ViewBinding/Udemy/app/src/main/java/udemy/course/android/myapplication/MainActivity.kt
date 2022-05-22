package udemy.course.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import udemy.course.android.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitName.setOnClickListener {
            displayName()
        }
    }

    private fun displayName(){
        binding.tvDisplayName.text = "Hello ${binding.etInputName.text}!"
    }
}