package udemy.course.summary.android.myapplication.workmanager.training.demo.chaining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityChainingRequestBinding
import udemy.course.summary.android.myapplication.workmanager.training.demo.chaining.work.CompressingWorker
import udemy.course.summary.android.myapplication.workmanager.training.demo.chaining.work.DownloadingWorker
import udemy.course.summary.android.myapplication.workmanager.training.demo.chaining.work.FilteringWorker
import udemy.course.summary.android.myapplication.workmanager.training.demo.onetimerequest.work.UploadWorker

class ChainingRequestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChainingRequestBinding

    //        define cons key_value
    companion object {
        const val KEY_VALUE = "key_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chaining_request)

        binding.btnChainingRequest.setOnClickListener {
            chainingRequest()
        }
    }

    private fun chainingRequest(){
        val workManager = WorkManager.getInstance(applicationContext)

        val data = Data.Builder().putInt(ChainingRequestActivity.KEY_VALUE, 125).build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()
        workManager.enqueue(uploadRequest)

        val filteringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
            .build()

        val compressingRequest = OneTimeWorkRequest.Builder(CompressingWorker::class.java)
            .build()

        val downloadingRequest = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
            .build()


//        make parallel requests
        val parallelWorks = mutableListOf<OneTimeWorkRequest>()
        parallelWorks.add(filteringRequest)
        parallelWorks.add(downloadingRequest)

        workManager
            .beginWith(parallelWorks)
            .then(uploadRequest)
            .then(compressingRequest)
            .enqueue()


/*//        make sequential request
        workManager
            .beginWith(uploadRequest)
            .then(filteringRequest)
            .then(compressingRequest)
            .then(downloadingRequest)
            .enqueue()*/

        //        Show and observe the work request
        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer{
            binding.textView.text = it.state.name
            if(it.state.isFinished){
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                binding.textView.text = "Finished at Chaining ${message}"
            }
        })
    }
}