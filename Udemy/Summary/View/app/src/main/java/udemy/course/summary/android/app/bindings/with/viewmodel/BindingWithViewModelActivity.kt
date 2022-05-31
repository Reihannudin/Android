package udemy.course.summary.android.app.bindings.with.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.bindings.with.viewmodel.viewmodel.VMBindingWithViewModel
import udemy.course.summary.android.app.databinding.ActivityBindingWithViewModelBinding

class BindingWithViewModelActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBindingWithViewModelBinding
    private lateinit var viewModel : VMBindingWithViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_with_view_model)
        viewModel = ViewModelProvider(this).get(VMBindingWithViewModel::class.java)
        binding.myViewModel = viewModel
        viewModel.counter.observe(this, androidx.lifecycle.Observer {
            binding.tvBindingWithViewModelValue.text = it.toString()
        })
    }
}