package udemy.course.summary.android.app.bindings.twoway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityBindingTwoWayBinding

class MainWayTwoBindActivity: AppCompatActivity() {

    private lateinit var binding : ActivityBindingTwoWayBinding
    private lateinit var viewModel : TwoWayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_two_way)
        viewModel = ViewModelProvider(this).get(TwoWayViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}