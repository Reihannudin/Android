package udemy.course.android.myapplication.lifecycle

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityLifecycleMainBinding

class LifecycleMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLifecycleMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lifecycle_main)

        lifecycleScope.launch {
            delay(5000)
            binding.progressBar.visibility = View.VISIBLE
            delay(8000)
            binding.progressBar.visibility = View.GONE
        }


    }
}