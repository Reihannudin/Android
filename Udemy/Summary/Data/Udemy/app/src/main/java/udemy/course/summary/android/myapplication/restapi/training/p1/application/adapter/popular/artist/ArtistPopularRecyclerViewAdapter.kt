package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.databinding.ItemListArtistPopularGridBinding
import udemy.course.summary.android.myapplication.databinding.ItemListMoviePopularGridBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.ArtistPopular
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie.MoviePopular

class ArtistPopularRecyclerViewAdapter : RecyclerView.Adapter<ArtistPopularRecyclerViewAdapter.ArtistPopularViewHolder>() {

    private val artistPopularList = ArrayList<ArtistPopular>()
    fun setList(artistPopular: List<ArtistPopular>) {
        artistPopularList.clear()
        artistPopularList.addAll(artistPopular)
    }

    inner class ArtistPopularViewHolder(private val binding : ItemListArtistPopularGridBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(artistPopular : ArtistPopular){
            binding.tvArtistName.text = artistPopular.name
            binding.tvPopulartyArtist.text = artistPopular.popularity.toString()

            val moviePopularURL = "https://image.tmdb.org/t/p/w500" + artistPopular.profilePath
            Glide.with(binding.ivArtistPoster.context ?: return binding.ivArtistPoster.setImageResource(
                R.drawable.blank_profile
            ))
                .load(moviePopularURL)
                .into(binding.ivArtistPoster)
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistPopularViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListArtistPopularGridBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_artist_popular_grid, parent, false)
        return ArtistPopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistPopularViewHolder, position: Int) {
        holder.bind(artistPopularList[position])
    }

    override fun getItemCount(): Int {
        return artistPopularList.size
    }
}