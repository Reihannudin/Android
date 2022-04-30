package udemy.course.android.architecture.databinding.twoway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityTwoWayMainBinding

class TwoWayMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTwoWayMainBinding
    private lateinit var viewModel : TwoWayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_main)
        viewModel = ViewModelProvider(this).get(TwoWayViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}