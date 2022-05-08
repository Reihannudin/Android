package udemy.course.android.architecture.more.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityChallengeMainBinding

class ChallengeMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChallengeMainBinding
    private lateinit var viewModel : ChallengeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge_main)
        viewModel = ViewModelProvider(this).get(ChallengeViewModel::class.java)

        binding.challengeViewModel = viewModel
        binding.lifecycleOwner = this



//        binding.tvResult.text = viewModel.GetCount().toString()
//
//        binding.btnAdd.setOnClickListener {
//            viewModel.setAddCount(binding.etSetNumber.text.toString().toInt())
//            binding.tvResult.text = viewModel.GetCount().toString()
//        }
    }
}