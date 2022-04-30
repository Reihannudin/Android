package udemy.course.android.architecture.viewmodels.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityPersonDataBindinigBinding
import udemy.course.android.architecture.databinding.ActivityProfileMainBinding

class ProfileMainActivityBinding  : AppCompatActivity() {
    private lateinit var binding : ActivityProfileMainBinding
    private lateinit var viewModel : ProfileMainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_main)
        viewModel = ViewModelProvider(this).get(ProfileMainViewModel::class.java)

        binding.tvUsername.text = viewModel.getUsername()

        binding.btnEditName.setOnClickListener {
            viewModel.editUsername(binding.etEditName.text.toString()).toString()
            binding.tvUsername.text = viewModel.getUsername()
        }

        binding.btnClear.setOnClickListener {
            viewModel.clearUsername()
            binding.tvUsername.text = viewModel.getUsername()
        }

    }
}