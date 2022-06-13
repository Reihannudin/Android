package udemy.course.summary.android.myapplication.workmanager.training.demo.chaining.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FilteringWorker(context: Context, params: WorkerParameters): Worker(context, params) {

    val Tag = "MyTag"
    override fun doWork(): Result {
        try{
            for(i in 0..3000){
                Log.i(Tag, "Filtering $i")
            }
            return Result.success()
        } catch(e: Exception){
            return Result.failure()
        }
    }
}
