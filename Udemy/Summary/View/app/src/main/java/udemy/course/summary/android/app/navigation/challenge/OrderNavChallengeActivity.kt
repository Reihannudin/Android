package udemy.course.summary.android.app.navigation.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityOrderNavChallengeBinding

class OrderNavChallengeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOrderNavChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_nav_challenge)
    }
}