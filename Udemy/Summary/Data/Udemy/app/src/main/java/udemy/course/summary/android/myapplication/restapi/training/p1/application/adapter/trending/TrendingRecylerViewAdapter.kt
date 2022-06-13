package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.databinding.ItemTrendingBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending.Trending

class TrendingRecylerViewAdapter : RecyclerView.Adapter<TrendingRecylerViewAdapter.TrendingRecylerViewHolder>() {

    private val trendingListFilm = ArrayList<Trending>()
    fun setList(trendingList: List<Trending>) {
        this.trendingListFilm.clear()
        this.trendingListFilm.addAll(trendingList)
    }

    inner class TrendingRecylerViewHolder(private val binding : ItemTrendingBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(trending: Trending) {
            binding.tvTrendingTitle.text = trending.title ?: trending.name
            binding.tvTrendingReleaseDate.text = trending.releaseDate ?: trending.firstAirDate
            val trendingURL = "https://image.tmdb.org/t/p/w500" + trending.posterPath
            Glide.with(binding.ivTrendingPoster.context)
                .load(trendingURL)
                .into(binding.ivTrendingPoster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRecylerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrendingBinding.inflate(layoutInflater, parent, false)
        return TrendingRecylerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingRecylerViewHolder, position: Int) {
        holder.bind(trendingListFilm[position])
    }

    override fun getItemCount(): Int {
        return trendingListFilm.size
    }
}