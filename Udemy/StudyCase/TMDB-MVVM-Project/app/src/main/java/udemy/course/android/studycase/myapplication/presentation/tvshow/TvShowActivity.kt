package udemy.course.android.studycase.myapplication.presentation.tvshow

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
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.databinding.ActivityTvShowBinding
import udemy.course.android.studycase.myapplication.presentation.di.Injector
import udemy.course.android.studycase.myapplication.presentation.tvshow.adapter.TvShowRecyclerViewAdapter
import udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel.TvShowViewModel
import udemy.course.android.studycase.myapplication.presentation.tvshow.viewmodel.factory.TvShowViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : TvShowViewModelFactory
    lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding : ActivityTvShowBinding
    private lateinit var adapter : TvShowRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvTvShowList.layoutManager = LinearLayoutManager(this)
        adapter = TvShowRecyclerViewAdapter()
        binding.rvTvShowList.adapter = adapter
        displayPopularTvShow()
    }

    private fun displayPopularTvShow(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShow()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_SHORT).show()

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.update_tv_show, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update_tv_show -> {
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShow(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.updateTvShow()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }
}