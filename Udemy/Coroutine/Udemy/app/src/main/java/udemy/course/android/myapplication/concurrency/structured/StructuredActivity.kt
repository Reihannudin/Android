package udemy.course.android.myapplication.concurrency.structured

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.*
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityStructuredBinding

class StructuredActivity : AppCompatActivity() {
    val Tag = "MyTag"
    private var count: Int = 0
    private lateinit var binding: ActivityStructuredBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_structured)

        binding.btnIncrement.setOnClickListener {
            binding.tvIncrementCount.text = count++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                binding.tvDataUserDownload.text = UserDataManagerStructured().getTotalUsers().toString()
            }
        }

        suspend fun downloadUserData() {
//        switch to Main thread from IO thread
            withContext(Dispatchers.Main) {
                for (i in 0..200000) {
//            Log.i(Tag, "Downloading user data $i in ${Thread.currentThread().name}")
                    binding.tvDataUserDownload.text =
                        "Downloading user data $i in ${Thread.currentThread().name}"
                    delay(10)
                }
            }
        }
    }
}
