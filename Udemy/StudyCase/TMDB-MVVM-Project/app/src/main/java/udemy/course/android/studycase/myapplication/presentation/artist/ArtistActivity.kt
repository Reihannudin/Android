package udemy.course.android.studycase.myapplication.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.databinding.ActivityArtistBinding
import udemy.course.android.studycase.myapplication.presentation.artist.adapter.ArtistRecyclerViewAdapter
import udemy.course.android.studycase.myapplication.presentation.artist.viewmodel.ArtistViewModel
import udemy.course.android.studycase.myapplication.presentation.artist.viewmodel.factory.ArtistViewModelFactory
import udemy.course.android.studycase.myapplication.presentation.di.Injector
import udemy.course.android.studycase.myapplication.presentation.movie.adapter.MovieRecyclerViewAdapter
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding : ActivityArtistBinding
    private lateinit var adapter : ArtistRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent().inject(this)

        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecylerView()
    }

    private fun initRecylerView(){
        binding.rvGridArtistList.layoutManager = GridLayoutManager(this, 2)
        adapter = ArtistRecyclerViewAdapter()
        binding.rvGridArtistList.adapter = adapter
        displayPopularArtist()
    }

    private fun displayPopularArtist(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this, Observer{
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update_artist, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update_artist-> {
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtist(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtist()
        responseLiveData.observe(this, Observer {
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }
}