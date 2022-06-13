package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.onair.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.R.drawable.blank_profile
import udemy.course.summary.android.myapplication.databinding.FragmentTvShowOnAirTmdbBinding
import udemy.course.summary.android.myapplication.databinding.ItemListTvShowOnAirBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie.MovieOnAir
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow.TvShowOnAir

class TvShowOnAirRwcyclerViewAdapter  : RecyclerView.Adapter<TvShowOnAirRwcyclerViewAdapter.TvShowOnAirViewHolder>() {

    private val tvShowOnAirList = ArrayList<TvShowOnAir>()
    fun setList(tvShowOnAir: List<TvShowOnAir>) {
        tvShowOnAirList.clear()
        tvShowOnAirList.addAll(tvShowOnAir)
    }

    inner class TvShowOnAirViewHolder(private val binding : ItemListTvShowOnAirBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowOnAir: TvShowOnAir) {
            binding.tvTvShowTitle.text = tvShowOnAir.name
            binding.tvTvShowReleaseDate.text = tvShowOnAir.firstAirDate
            val tvShowPopularURL = "https://image.tmdb.org/t/p/w500" + tvShowOnAir.posterPath
            Glide.with(binding.ivTvShowPoster.context ?: return binding.ivTvShowPoster.setImageResource(blank_profile))
                .load(tvShowPopularURL)
                .into(binding.ivTvShowPoster)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowOnAirViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListTvShowOnAirBinding.inflate(layoutInflater, parent, false)
        return TvShowOnAirViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowOnAirViewHolder, position: Int) {
        holder.bind(tvShowOnAirList[position])
    }

    override fun getItemCount(): Int {
        return tvShowOnAirList.size
    }
}
