package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.trending

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
import udemy.course.summary.android.myapplication.databinding.FragmentTrendingTmdbBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.movie.MoviePopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.tvshow.TvShowPopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.trending.TrendingRecylerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.MoviePopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.factory.MoviePopularViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.TvShowPopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending.TrendingViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.trending.factory.TrendingViewModelFactory
import javax.inject.Inject

class TrendingTMDBFragment : Fragment() {

    @Inject
    lateinit var factory : TrendingViewModelFactory
    private lateinit var trendingViewModel : TrendingViewModel
    private lateinit var binding : FragmentTrendingTmdbBinding
    private lateinit var adapter : TrendingRecylerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trending_tmdb, container, false)

        ( activity?.application as Injector).createTrendingSubComponent().inject(this)
        trendingViewModel = ViewModelProvider(this,factory).get(TrendingViewModel::class.java)

        initRecyclerView()
        btnUpdateTrending()
        backToHome()

        return binding.root
    }

    private fun initRecyclerView(){ //GridLayoutManager(this, 2) LinearLayoutManager(context)
        binding.rvTrending.layoutManager = GridLayoutManager(context, 2)
        adapter = TrendingRecylerViewAdapter()
        binding.rvTrending.adapter = adapter
        displayTrending()
    }

    private fun displayTrending(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = trendingViewModel.getTrending()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("TMDB-API","Response Trending film : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun btnUpdateTrending(){
        binding.ivRefresh.setOnClickListener{
            updateTvShowPopular()
        }
    }

    private fun backToHome(){
        binding.ivBackToHome.setOnClickListener{
            it.findNavController().navigate(R.id.action_trendingTMDBFragment_to_homeTMDBFragment)
        }
    }

    private fun updateTvShowPopular(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = trendingViewModel.updateTrending()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}