package udemy.course.android.studycase.myapplication.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.databinding.ActivityMovieBinding
import udemy.course.android.studycase.myapplication.presentation.di.Injector
import udemy.course.android.studycase.myapplication.presentation.movie.adapter.MovieRecyclerViewAdapter
import udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.MovieViewModel
import udemy.course.android.studycase.myapplication.presentation.movie.viewmodel.factory.MovieViewModelFactory
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : MovieViewModelFactory
    private lateinit var movieViewModel : MovieViewModel
    private lateinit var binding : ActivityMovieBinding
    private lateinit var adapter : MovieRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvMovieList.layoutManager = LinearLayoutManager(this)
        adapter = MovieRecyclerViewAdapter()
        binding.rvMovieList.adapter = adapter
        displayPopularMovie()
    }

    private fun displayPopularMovie(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovie()
        responseLiveData.observe(this, Observer {
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update_movie, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update_movie-> {
                updateMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovie(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovie()
        responseLiveData.observe(this, Observer {
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
