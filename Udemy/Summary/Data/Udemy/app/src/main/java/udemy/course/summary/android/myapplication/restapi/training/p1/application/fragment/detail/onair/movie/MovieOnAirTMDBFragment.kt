package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.onair.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.FragmentMovieOnAirTmdbBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.onair.movie.MovieOnAirRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie.MovieOnAirViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.onair.movie.factory.MovieOnAirViewModelFactory
import javax.inject.Inject

class MovieOnAirTMDBFragment : Fragment() {

    @Inject
    lateinit var factory : MovieOnAirViewModelFactory
    private lateinit var movieViewModel : MovieOnAirViewModel
    private lateinit var binding : FragmentMovieOnAirTmdbBinding
    private lateinit var adapter : MovieOnAirRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_on_air_tmdb, container, false)

        ( activity?.application as Injector).createMovieOnAirSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MovieOnAirViewModel::class.java)

        initRecylerView()
        btnUpdateMoviePopular()
        backToHome()

        return binding.root
    }

    private fun backToHome(){
        binding.ivBackToHome.setOnClickListener{
            it.findNavController().navigate(R.id.action_movieOnAirTMDBFragment_to_homeTMDBFragment)
        }
    }

    private fun btnUpdateMoviePopular(){
        binding.ivRefresh.setOnClickListener{
            updateMoviePopular()
        }
    }
    private fun updateMoviePopular(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovieOnAir()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecylerView() {
        binding.rvMoviePopular.layoutManager = GridLayoutManager(context,2)
        adapter = MovieOnAirRecyclerViewAdapter()
        binding.rvMoviePopular.adapter = adapter
        displayMovieOnAir()
    }

    private fun displayMovieOnAir(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovieOnAir()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_SHORT).show()
            }
        })

    }

}