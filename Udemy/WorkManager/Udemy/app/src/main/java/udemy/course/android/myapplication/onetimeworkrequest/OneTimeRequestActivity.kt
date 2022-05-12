package udemy.course.android.myapplication.onetimeworkrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityOneTimeRequestBinding

class OneTimeRequestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOneTimeRequestBinding

    //        define cons key_value
    companion object {
        const val KEY_VALUE = "key_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_one_time_request)
        binding.btnDownload.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){
//        define work manager
        val workManager = WorkManager.getInstance(applicationContext)

//        define a data class
        val data = Data.Builder().putInt(KEY_VALUE, 125).build()

//        define Constraints
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

//        define OneTimeWorkRequest
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints) //set constraints
            .setInputData(data) // set data
            .build()
        workManager.enqueue(uploadRequest) // enqueue the work request
//        Show and observe the work request
        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer{
            binding.tvStatus.text = it.state.name
            if(it.state.isFinished){
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                binding.tvDate.text = "Finished at $message"
            }
        })
    }
}