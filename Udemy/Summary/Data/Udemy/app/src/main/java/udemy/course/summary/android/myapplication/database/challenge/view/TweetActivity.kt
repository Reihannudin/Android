package udemy.course.summary.android.myapplication.database.challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityTweetBinding

class TweetActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTweetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tweet)

        binding

    }
}