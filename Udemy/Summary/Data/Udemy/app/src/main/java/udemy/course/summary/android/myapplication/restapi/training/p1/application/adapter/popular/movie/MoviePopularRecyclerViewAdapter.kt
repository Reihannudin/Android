package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.movie

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ItemListMoviePopularBinding
import udemy.course.summary.android.myapplication.databinding.ItemListMoviePopularGridBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MovieListPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

class MoviePopularRecyclerViewAdapter : RecyclerView.Adapter<MoviePopularRecyclerViewAdapter.MoviePopularRecyclerViewHolder>() {

    private val moviePopularList = ArrayList<MoviePopular>()
    fun setList(moviePopular: List<MoviePopular>) {
        moviePopularList.clear()
        moviePopularList.addAll(moviePopular)
    }
//ItemListMoviePopularBinding
    inner class MoviePopularRecyclerViewHolder(private val binding : ItemListMoviePopularGridBinding )
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(moviePopular : MoviePopular){
                binding.tvMovieTitle.text = moviePopular.title
                binding.tvMovieReleaseDate.text = moviePopular.releaseDate
                val moviePopularURL = "https://image.tmdb.org/t/p/w500" + moviePopular.posterPath
                Glide.with(binding.ivMoviePoster.context)
                    .load(moviePopularURL)
                    .into(binding.ivMoviePoster)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePopularRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :  ItemListMoviePopularGridBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_movie_popular_grid, parent, false)
        return MoviePopularRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviePopularRecyclerViewHolder, position: Int) {
        holder.bind(moviePopularList[position])
    }

    override fun getItemCount(): Int {
        return moviePopularList.size
    }
}