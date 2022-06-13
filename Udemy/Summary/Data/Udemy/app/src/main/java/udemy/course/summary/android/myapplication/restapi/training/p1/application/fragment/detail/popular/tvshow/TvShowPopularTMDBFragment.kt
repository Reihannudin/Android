package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.tvshow

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
import udemy.course.summary.android.myapplication.databinding.FragmentTvShowPopularTmdbBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.tvshow.TvShowPopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.MoviePopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.TvShowPopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.tvshow.factory.TvShowPopularViewModelFactory
import javax.inject.Inject

class TvShowPopularTMDBFragment : Fragment() {

    @Inject
    lateinit var factory : TvShowPopularViewModelFactory
    private lateinit var tvShowViewModel : TvShowPopularViewModel
    private lateinit var binding : FragmentTvShowPopularTmdbBinding
    private lateinit var adapter : TvShowPopularRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_show_popular_tmdb, container, false)

        ( activity?.application as Injector).createTvShowPopularSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this,factory).get(TvShowPopularViewModel::class.java)

        initRecyclerView()
        btnUpdateTvShowPopular()
        backToHome()

        return binding.root
    }

    private fun btnUpdateTvShowPopular(){
        binding.ivRefresh.setOnClickListener{
            updateTvShowPopular()
        }
    }

    private fun backToHome(){
        binding.ivBackToHome.setOnClickListener{
            it.findNavController().navigate(R.id.action_tvShowPopularTMDBFragment_to_homeTMDBFragment)
        }
    }

    private fun initRecyclerView(){
        binding.rvtvShowPopular.layoutManager = GridLayoutManager(context,2)
        adapter = TvShowPopularRecyclerViewAdapter()
        binding.rvtvShowPopular.adapter = adapter
        displayTvShowPopular()
    }

    private fun displayTvShowPopular(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShowPopular()
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

    private fun updateTvShowPopular(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData =tvShowViewModel.updateTvShowPopular()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }
}