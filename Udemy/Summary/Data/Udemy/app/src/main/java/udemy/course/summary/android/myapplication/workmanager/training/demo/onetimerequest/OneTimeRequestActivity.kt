package udemy.course.summary.android.myapplication.workmanager.training.demo.onetimerequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityWorkManagerBinding
import udemy.course.summary.android.myapplication.workmanager.training.demo.onetimerequest.work.UploadWorker

class OneTimeRequestActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWorkManagerBinding

    companion object{
        const val KEY_VALUE = "key_value"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)

        binding.btnOneTimeRequest.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){
//        define work manager
        val workManager = WorkManager.getInstance(applicationContext)

//        define data class
        val data: Data = Data.Builder()
            .putInt(KEY_VALUE, 111)
            .build()

//        define constraints
        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

//        define work request
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraint)
            .setInputData(data)
            .build()
        workManager.enqueue(uploadRequest)

        //        Show and observe the work request
        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer{
            binding.textView.text = it.state.name
            if(it.state.isFinished){
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                binding.textView.text = "Finished at ${message}"
            }
        })
    }
}