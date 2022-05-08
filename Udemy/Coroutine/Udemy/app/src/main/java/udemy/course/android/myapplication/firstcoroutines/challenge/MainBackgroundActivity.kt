package udemy.course.android.myapplication.firstcoroutines.challenge

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityMainBackgroundBinding

class MainBackgroundActivity: AppCompatActivity() {
    private lateinit var binding : ActivityMainBackgroundBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_background)

        binding.btnClickMain.setOnClickListener {
            CoroutineScope(Main).launch {
                Toast.makeText(this@MainBackgroundActivity, "Clicked ${Thread.currentThread().name}", Toast.LENGTH_SHORT).show()
                Log.i("MyTag", "Clicked ${Thread.currentThread().name}")
            }
        }

        binding.btnClickBackground.setOnClickListener {
            CoroutineScope(IO).launch {
                Log.i("MyTag", "Clicked ${Thread.currentThread().name}")
//                Toast.makeText(this@MainBackgroundActivity, "Clicked ${Thread.currentThread().name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}