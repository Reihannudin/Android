package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.FragmentHomeTmdbBinding

class HomeTMDBFragment : Fragment() {

    private lateinit var binding : FragmentHomeTmdbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_tmdb, container, false)

        binding.btnTrending.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_trendingTMDBFragment)
            Toast.makeText(context, "To Trending page", Toast.LENGTH_SHORT).show()
        }

        binding.btnPopularMovie.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_moviePopularTMDBFragment)
            Toast.makeText(context, "To Popular Movie page", Toast.LENGTH_SHORT).show()
        }

        binding.btnPopularTvShow.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_tvShowPopularTMDBFragment)
            Toast.makeText(context, "To Popular Tv Show page", Toast.LENGTH_SHORT).show()
        }

        binding.btnPopularArtist.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_artistPopularTMDBFragment)
            Toast.makeText(context, "To Popular Artist page", Toast.LENGTH_SHORT).show()
        }

        binding.btnOnAirMovie.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_movieOnAirTMDBFragment)
            Toast.makeText(context, "To On Air Movie page", Toast.LENGTH_SHORT).show()
        }

        binding.btnOnAirTvShow.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_homeTMDBFragment_to_tvShowOnAirTMDBFragment)
            Toast.makeText(context, "To On Air TV Show page", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}