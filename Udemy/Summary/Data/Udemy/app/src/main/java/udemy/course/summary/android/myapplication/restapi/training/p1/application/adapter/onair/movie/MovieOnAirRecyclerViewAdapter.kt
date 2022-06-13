package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.onair.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.databinding.ItemListMovieOnAirBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

class MovieOnAirRecyclerViewAdapter : RecyclerView.Adapter<MovieOnAirRecyclerViewAdapter.MovieOnAirViewHolder>() {

    private val movieOnAirList = ArrayList<MovieOnAir>()
    fun setList(movieOnAir: List<MovieOnAir>) {
        movieOnAirList.clear()
        movieOnAirList.addAll(movieOnAir)
    }

    inner class MovieOnAirViewHolder(private val binding : ItemListMovieOnAirBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieOnAir : MovieOnAir) {
            binding.tvMovieTitle.text = movieOnAir.title
            binding.tvMovieReleaseDate.text = movieOnAir.releaseDate
            val moviePopularURL = "https://image.tmdb.org/t/p/w500" + movieOnAir.posterPath
            Glide.with(binding.ivMoviePoster.context)
                .load(moviePopularURL)
                .into(binding.ivMoviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieOnAirViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListMovieOnAirBinding = ItemListMovieOnAirBinding.inflate(layoutInflater, parent, false)
        return MovieOnAirViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieOnAirViewHolder, position: Int) {
        holder.bind(movieOnAirList[position])
    }

    override fun getItemCount(): Int {
        return movieOnAirList.size
    }
}