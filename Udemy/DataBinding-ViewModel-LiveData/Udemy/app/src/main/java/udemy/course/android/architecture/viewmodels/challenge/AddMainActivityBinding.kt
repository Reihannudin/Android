package udemy.course.android.architecture.viewmodels.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityAddMainBinding
import udemy.course.android.architecture.livedata.livesdata.AddLiveDataMainViewModel
import udemy.course.android.architecture.viewmodels.challenge.viewmodelfactory.AddLiveDataMainViewModelFactory

class AddMainActivityBinding : AppCompatActivity() {

    private lateinit var binding : ActivityAddMainBinding
    private lateinit var viewModelLiveData : AddLiveDataMainViewModel
    private lateinit var viewModelFactoryLiveData : AddLiveDataMainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_main)
        viewModelFactoryLiveData = AddLiveDataMainViewModelFactory(125)
        viewModelLiveData = ViewModelProvider(this, viewModelFactoryLiveData).get(
            AddLiveDataMainViewModel::class.java)

        binding.tvResult.text = viewModelLiveData.getTotal().toString()

        binding.btnAdd.setOnClickListener {
            viewModelLiveData.setAddTotal(binding.etSetNumber.text.toString().toInt())
            binding.tvResult.text = viewModelLiveData.getTotal().toString()
        }

        binding.btnMin.setOnClickListener {
            viewModelLiveData.setMinTotal(binding.etSetNumber.text.toString().toInt())
            binding.tvResult.text = viewModelLiveData.getTotal().toString()
        }

        binding.btnClear.setOnClickListener {
            viewModelLiveData.clearTotal()
            binding.tvResult.text = viewModelLiveData.getTotal().toString()
        }

    }
}