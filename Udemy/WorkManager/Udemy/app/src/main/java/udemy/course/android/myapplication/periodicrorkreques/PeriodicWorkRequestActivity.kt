package udemy.course.android.myapplication.periodicrorkreques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityPeriodicWorkRequestBinding
import java.util.concurrent.TimeUnit

class PeriodicWorkRequestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPeriodicWorkRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_periodic_work_request)

        binding.btnDownload.setOnClickListener {
            periodicWorkRequest()
        }
    }

    private fun periodicWorkRequest() {
        val periodicWorkRequest = PeriodicWorkRequest
            .Builder(DownloadingPeriordicWorker::class.java, 16, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
        }
}