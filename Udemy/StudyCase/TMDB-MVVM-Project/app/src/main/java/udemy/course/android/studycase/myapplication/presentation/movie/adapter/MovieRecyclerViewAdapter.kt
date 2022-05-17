package udemy.course.android.studycase.myapplication.presentation.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.data.model.movie.Movie
import udemy.course.android.studycase.myapplication.databinding.ItemListMovieBinding

class MovieRecyclerViewAdapter : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()
    fun setList(movie: List<Movie>){
        movieList.clear()
        movieList.addAll(movie)
    }

    inner class MovieViewHolder(val binding : ItemListMovieBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun bind(movie: Movie){
                binding.tvMovieTitle.text = movie.title
                binding.tvMovieOveriview.text = movie.overview
                binding.tvMovieReleaseDate.text = movie.releaseDate
//                define poster path API
                val moviePosterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
                Glide.with(binding.ivMoviePoster.context)
                    .load(moviePosterUrl)
                    .into(binding.ivMoviePoster)
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListMovieBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_list_movie,parent,false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}