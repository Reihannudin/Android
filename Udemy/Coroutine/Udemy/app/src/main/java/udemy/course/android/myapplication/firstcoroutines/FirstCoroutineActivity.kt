package udemy.course.android.myapplication.firstcoroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityFirstCoroutineBinding

class FirstCoroutineActivity  : AppCompatActivity(){

    val Tag = "MyTag"
    private var count : Int = 0
    private lateinit var binding : ActivityFirstCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first_coroutine)

        binding.btnIncrement.setOnClickListener {
            binding.tvIncrementCount.text = count++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData(){
//        switch to Main thread from IO thread
        withContext(Main){
            for(i in 0..200000){
//            Log.i(Tag, "Downloading user data $i in ${Thread.currentThread().name}")
                binding.tvDataUserDownload.text = "Downloading user data $i in ${Thread.currentThread().name}"
                delay(10)
            }
        }
    }
}