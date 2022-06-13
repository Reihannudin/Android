package udemy.course.summary.android.myapplication.restapi.training.pt1.application.fragment.detail.popular.artist

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
import udemy.course.summary.android.myapplication.databinding.FragmentArtistPopularTmdbBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.artist.ArtistPopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.movie.MoviePopularRecyclerViewAdapter
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.dependencyinjection.Injector
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist.ArtistPopularViewModel
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.artist.factory.ArtistPopularViewModelFactory
import udemy.course.summary.android.myapplication.restapi.training.pt1.application.viewmodel.popular.movie.MoviePopularViewModel
import javax.inject.Inject

class ArtistPopularTMDBFragment : Fragment() {

    @Inject
    lateinit var factory : ArtistPopularViewModelFactory
    private lateinit var artistViewModel : ArtistPopularViewModel
    private lateinit var binding : FragmentArtistPopularTmdbBinding
    private lateinit var adapter : ArtistPopularRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist_popular_tmdb, container, false)

        ( activity?.application as Injector).createArtistPopularSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this,factory).get(ArtistPopularViewModel::class.java)

        initRecyclerView()
        btnUpdateArtistPopular()
        backToHome()

        return binding.root
    }

    private fun btnUpdateArtistPopular(){
        binding.ivRefresh.setOnClickListener{
            updateArtistPopular()
        }
    }

    private fun updateArtistPopular(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtistPopular()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun backToHome(){
        binding.ivBackToHome.setOnClickListener{
            it.findNavController().navigate(R.id.action_artistPopularTMDBFragment_to_homeTMDBFragment)
        }
    }

    private fun initRecyclerView(){
        binding.rvArtistPopular.layoutManager = GridLayoutManager(context, 2)
        adapter = ArtistPopularRecyclerViewAdapter()
        binding.rvArtistPopular.adapter = adapter
        displayArtistPopular()
    }

    private fun displayArtistPopular(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtistPopular()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            Log.i("TMDB-API","Response movie popular : $it")
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

}