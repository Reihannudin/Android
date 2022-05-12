package udemy.course.android.myapplication.onetimeworkrequest

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import udemy.course.android.myapplication.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context:Context,params:WorkerParameters): Worker(context, params) {

    companion object{
        const val KEY_WORKER = "key_worker"
    }

    val Tag = "MyTag"
    override fun doWork(): Result {
        try{
            val count = inputData.getInt(OneTimeRequestActivity.KEY_VALUE,0)
//            for(i in 0..60000){
                for(i in 0 until count){
                    Log.i(Tag, "Uploading $i")
                }
//            }
            val time = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            val currentDate = time.format(Date())

            val outPutData = Data.Builder().putString(KEY_WORKER, currentDate).build()

            return Result.success(outPutData)
        } catch(e: Exception){
            return Result.failure()
        }
    }
}