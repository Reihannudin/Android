package udemy.course.summary.android.myapplication.workmanager.training.demo.onetimerequest.work

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import udemy.course.summary.android.myapplication.workmanager.training.demo.onetimerequest.OneTimeRequestActivity
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context : Context, params : WorkerParameters)
    : Worker(context,params) {

    companion object{
        const val KEY_WORKER = "key_worker"
    }

    override fun doWork(): Result {
        try{
            val input = inputData.getInt(OneTimeRequestActivity.KEY_VALUE,0)
//            for (i in 0..10000){
            for (i in 0 until input){
                Log.i("MyTag","Uploading $i")
            }
            val time = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outPutData = Data.Builder().putString(KEY_WORKER,currentDate).build()

            return Result.success(outPutData)
        } catch (e: Exception){
            return Result.failure()
        }
    }
}