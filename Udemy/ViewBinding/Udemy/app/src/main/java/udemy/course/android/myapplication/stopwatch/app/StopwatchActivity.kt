package udemy.course.android.myapplication.stopwatch.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityStopwatchBinding
import udemy.course.android.myapplication.stopwatch.service.StopWatchService
import kotlin.math.roundToInt

class StopwatchActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStopwatchBinding
    private var isStarted : Boolean = false
    private lateinit var serviceIntent : Intent
    private var time : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartTime.setOnClickListener {
            startOrStop()
        }
        binding.btnResetTime.setOnClickListener {
            reset()
        }

        serviceIntent = Intent(this, StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATE_TIME))
    }

    private fun startOrStop() {
        if (isStarted) {
            stop()
        } else {
            start()
        }
    }

    private fun start(){
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME,time)
        startService(serviceIntent)
        isStarted = true
        binding.btnStartTime.text = "Stop"
    }

    private fun stop(){
        stopService(serviceIntent)
        isStarted = false
        binding.btnStartTime.text = "Start"
    }

    private fun reset(){
        stop()
        time = 0.0
        binding.tvDefaultTime.text = getFormattedTime(time)
    }

    private val updateTime : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(StopWatchService.CURRENT_TIME,0.0)
            binding.tvDefaultTime.text = getFormattedTime(time)
        }
    }

    private fun getFormattedTime(time:Double):String {
        val timeInt = time.roundToInt()
        val hours = timeInt % 86400 / 3600
        val minutes = timeInt %86400 % 3600 / 60
        val seconds = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d",hours,minutes,seconds)
    }
}