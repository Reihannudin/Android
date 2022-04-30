package udemy.course.android.architecture.livedata.livesdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityAddMainBinding
import udemy.course.android.architecture.viewmodels.challenge.viewmodelfactory.AddLiveDataMainViewModelFactory

class AddLiveDataMainActivityBinding : AppCompatActivity() {

    private lateinit var binding : ActivityAddMainBinding
    private lateinit var viewModelLiveData : AddLiveDataMainViewModel
    private lateinit var viewModelFactoryLiveData : AddLiveDataMainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_main)
        viewModelFactoryLiveData = AddLiveDataMainViewModelFactory(125)
        viewModelLiveData = ViewModelProvider(this, viewModelFactoryLiveData).get(
            AddLiveDataMainViewModel::class.java)

//        define livedata observer
        viewModelLiveData.totalLiveData.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })

        binding.btnAdd.setOnClickListener {
            viewModelLiveData.setAddTotal(binding.etSetNumber.text.toString().toInt())
        }

        binding.btnMin.setOnClickListener {
            viewModelLiveData.setMinTotal(binding.etSetNumber.text.toString().toInt())
        }

        binding.btnClear.setOnClickListener {
            viewModelLiveData.clearTotal()
        }

    }
}