package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.movie

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
import androidx.recyclerview.widget.LinearLayoutManager
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.FragmentMoviePopularTmdbBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.movie.MoviePopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.MoviePopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.factory.MoviePopularViewModelFactory
import javax.inject.Inject

class MoviePopularTMDBFragment : Fragment() {

    @Inject
    lateinit var factory : MoviePopularViewModelFactory
    private lateinit var movieViewModel : MoviePopularViewModel
    private lateinit var binding : FragmentMoviePopularTmdbBinding
    private lateinit var adapter : MoviePopularRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_popular_tmdb, container, false)

        ( activity?.application as Injector ).createMoviePopularSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MoviePopularViewModel::class.java)

        initRecyclerView()
        btnUpdateMoviePopular()
        backToHome()

        return binding.root
    }

    private fun initRecyclerView(){ //GridLayoutManager(this, 2) LinearLayoutManager(context)
        binding.rvMoviePopular.layoutManager = GridLayoutManager(context, 2)
        adapter = MoviePopularRecyclerViewAdapter()
        binding.rvMoviePopular.adapter = adapter
        displayMoviePopular()
    }

    private fun btnUpdateMoviePopular(){
        binding.ivRefresh.setOnClickListener{
            updateMoviePopular()
        }
    }

    private fun backToHome(){
        binding.ivBackToHome.setOnClickListener{
            it.findNavController().navigate(R.id.action_moviePopularTMDBFragment_to_homeTMDBFragment)
        }
    }

    private fun displayMoviePopular(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMoviePopular()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateMoviePopular(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMoviePopular()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }
}