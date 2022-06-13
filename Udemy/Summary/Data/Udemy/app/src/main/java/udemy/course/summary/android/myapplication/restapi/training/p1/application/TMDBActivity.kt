package udemy.course.summary.android.myapplication.restapi.training.pt1.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ActivityTmdbBinding

class TMDBActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTmdbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tmdb)
    }
}