package udemy.course.android.studycase.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.databinding.ActivityMainBinding
import udemy.course.android.studycase.myapplication.presentation.artist.ArtistActivity
import udemy.course.android.studycase.myapplication.presentation.movie.MovieActivity
import udemy.course.android.studycase.myapplication.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnMovie.setOnClickListener{
            Intent(this, MovieActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnArtist.setOnClickListener{
            Intent(this, ArtistActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTvShow.setOnClickListener{
            Intent(this, TvShowActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}