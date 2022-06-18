package dicoding.submission.reihannudin.pt1.rev.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import dicoding.submission.reihannudin.pt1.rev.R
import dicoding.submission.reihannudin.pt1.rev.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding

    private var title : String = "About"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvProfileName.text = "Andrian Raihannudin"
        binding.tvProfileEmail.text = "ceritafilmy3@gmail.com"
        binding.profileImage.setImageResource(R.drawable.profile)

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}