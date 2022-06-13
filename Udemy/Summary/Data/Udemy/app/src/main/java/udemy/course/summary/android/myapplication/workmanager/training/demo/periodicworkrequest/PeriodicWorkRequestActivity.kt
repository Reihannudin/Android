package udemy.course.summary.android.myapplication.workmanager.training.demo.periodicworkrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityPeriodicWorkRequestBinding
import udemy.course.summary.android.myapplication.workmanager.training.demo.periodicworkrequest.work.DownloadingPeriodicWorker
import java.util.concurrent.TimeUnit

class PeriodicWorkRequestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPeriodicWorkRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_periodic_work_request)

        binding.btnPeriodicRequest.setOnClickListener {
            periodicWorkRequest()
        }
    }
    private fun periodicWorkRequest() {
        val periodicWorkRequestActivity = PeriodicWorkRequest
            .Builder(DownloadingPeriodicWorker::class.java, 16, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequestActivity)
    }
}