
package dicoding.submission.reihannudin.pt1.rev.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dicoding.submission.reihannudin.pt1.rev.R
import dicoding.submission.reihannudin.pt1.rev.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        binding.ivMcd.alpha = 0f
        binding.ivMcd.animate().setDuration(1300).alpha(1f).withEndAction{
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
}