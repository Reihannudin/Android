package udemy.course.summary.android.app.bindings.with.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.bindings.with.viewmodel.viewmodel.VMBindingWithViewModel
import udemy.course.summary.android.app.databinding.ActivityBindingWithLiveDataBinding

class BindingWithLiveDataActivity: AppCompatActivity() {

    private lateinit var binding : ActivityBindingWithLiveDataBinding
    private lateinit var viewModel : VMBindingWithViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_with_live_data)
        viewModel = ViewModelProvider(this).get(VMBindingWithViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

    }
}