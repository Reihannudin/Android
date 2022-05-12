package udemy.course.android.myapplication.periodicrorkreques

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class DownloadingPeriordicWorker (context: Context, params: WorkerParameters): Worker(context, params) {

    val Tag = "MyTag"
    override fun doWork(): Result {
        try{
            for(i in 0..3000){
                Log.i(Tag, "Downloading $i")
            }
            val time = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            val currentDate = time.format(Date())
            Log.i(Tag, "Downloading finished at $currentDate")
            return Result.success()
        } catch(e: Exception){
            return Result.failure()
        }
    }
}