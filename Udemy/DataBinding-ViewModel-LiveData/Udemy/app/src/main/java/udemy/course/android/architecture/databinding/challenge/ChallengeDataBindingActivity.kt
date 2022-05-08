package udemy.course.android.architecture.databinding.challenge

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import udemy.course.android.architecture.R
import udemy.course.android.architecture.databinding.ActivityChallengeDatabindingBinding

class ChallengeDataBindingActivity: AppCompatActivity() {

    private lateinit var binding : ActivityChallengeDatabindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge_databinding)

            binding.btnStart.setOnClickListener {
            startOrStopProgress()
        }
    }

    private fun startOrStopProgress(){
        if(binding.progressBar.visibility == ProgressBar.GONE){
            binding.progressBar.visibility = ProgressBar.VISIBLE
            binding.btnStart.text = "Stop"
        }else{
            binding.progressBar.visibility = ProgressBar.GONE
            binding.btnStart.text = "Start"
        }
    }
}