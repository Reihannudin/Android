package udemy.course.android.architecture.viewmodels.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityMainCountBinding
import udemy.course.android.architecture.livedata.challenge.livedata.CountLiveDataMainActivityViewModel

class CountMainActivityBinding : AppCompatActivity(){
    private lateinit var binding : ActivityMainCountBinding
    private lateinit var viewModelLiveData : CountLiveDataMainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_count)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_count)
//        define view model
        viewModelLiveData = ViewModelProvider(this).get(CountLiveDataMainActivityViewModel::class.java)

/*      Without ViewModel
        binding.countText.text = count.toString()*/

//        With ViewModel
        binding.countText.text = viewModelLiveData.getCount().toString()

        binding.btnCountIncrement.setOnClickListener {
//            with ViewModel
            binding.countText.text = viewModelLiveData.IncrementCount().toString()

/*
            Without ViewModel
            count++
            binding.countText.text = count.toString()
*/
        }

        binding.btnCountDecrement.setOnClickListener {
//            with ViewModel
            binding.countText.text = viewModelLiveData.decrementCount().toString()
        }
    }
}