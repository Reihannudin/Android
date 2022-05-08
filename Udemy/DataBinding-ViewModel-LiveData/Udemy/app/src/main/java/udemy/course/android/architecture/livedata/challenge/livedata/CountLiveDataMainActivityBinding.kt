package udemy.course.android.architecture.livedata.challenge.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityMainCountBinding

class CountLiveDataMainActivityBinding : AppCompatActivity(){
    private lateinit var binding : ActivityMainCountBinding
    private lateinit var viewModelLiveData : CountLiveDataMainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_count)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_count)
//        define view model
        viewModelLiveData = ViewModelProvider(this).get(CountLiveDataMainActivityViewModel::class.java)

//        define livedata observer
        viewModelLiveData.countLiveData.observe(this, Observer {
            binding.countText.text = it.toString()
        })

        binding.btnCountIncrement.setOnClickListener {
//            with ViewModel
            binding.countText.text = viewModelLiveData.IncrementCount().toString()
        }

        binding.btnCountDecrement.setOnClickListener {
//            with ViewModel
            binding.countText.text = viewModelLiveData.decrementCount().toString()
        }
    }
}