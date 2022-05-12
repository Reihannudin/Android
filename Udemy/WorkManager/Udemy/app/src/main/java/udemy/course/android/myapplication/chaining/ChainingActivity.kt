package udemy.course.android.myapplication.chaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityChainingBinding
import udemy.course.android.myapplication.onetimeworkrequest.OneTimeRequestActivity
import udemy.course.android.myapplication.onetimeworkrequest.UploadWorker

class ChainingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChainingBinding

    //        define cons key_value
    companion object {
        const val KEY_VALUE = "key_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chaining)

        binding.btnDownload.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){

        val workManager = WorkManager.getInstance(applicationContext)

        val data = Data.Builder().putInt(OneTimeRequestActivity.KEY_VALUE, 125).build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

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

/*
//        make sequential request
        workManager
            .beginWith(uploadRequest)
            .then(filteringRequest)
            .then(compressingRequest)
            .enqueue()
*/

        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer {
            binding.tvStatus.text = it.state.name
            if(it.state.isFinished){
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        })

    }
}
