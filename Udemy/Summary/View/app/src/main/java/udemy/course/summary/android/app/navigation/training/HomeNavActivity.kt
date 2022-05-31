package udemy.course.summary.android.app.navigation.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.summary.android.app.R
import udemy.course.summary.android.app.databinding.ActivityHomeNavBinding

class HomeNavActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_nav)
    }
}