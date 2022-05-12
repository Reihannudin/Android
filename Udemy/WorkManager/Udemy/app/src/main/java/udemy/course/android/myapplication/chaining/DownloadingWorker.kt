package udemy.course.android.myapplication.chaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadingWorker (context: Context, params: WorkerParameters): Worker(context, params) {

    val Tag = "MyTag"
    override fun doWork(): Result {
        try{
            for(i in 0..3000){
                Log.i(Tag, "Downloading $i")
            }
            return Result.success()
        } catch(e: Exception){
            return Result.failure()
        }
    }
}