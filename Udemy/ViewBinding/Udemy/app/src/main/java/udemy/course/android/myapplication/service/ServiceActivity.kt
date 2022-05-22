package udemy.course.android.myapplication.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityServiceBinding
import udemy.course.android.myapplication.service.MyBackgroundService.Companion.AGE
import udemy.course.android.myapplication.service.MyBackgroundService.Companion.NAME
import udemy.course.android.myapplication.service.MyBackgroundService.Companion.Tag

class ServiceActivity : AppCompatActivity() {


    private lateinit var binding : ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        make intent service
        val serviceIntent = Intent(this, MyBackgroundService::class.java)

//        make extra put
        serviceIntent.putExtra(NAME, "Reihan")
        serviceIntent.putExtra(AGE, 16)

        binding.btnStart.setOnClickListener {
            Log.i(Tag, "Start service")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.i(Tag, "Stop service")
            stopService(serviceIntent)
        }

    }
}