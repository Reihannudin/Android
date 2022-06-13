package udemy.course.summary.android.myapplication.restapi.training.pt1.application.adapter.popular.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.summary.android.myapplication.databinding.ItemListTvShowGridBinding
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow.TvShowPopular

class TvShowPopularRecyclerViewAdapter : RecyclerView.Adapter<TvShowPopularRecyclerViewAdapter.TvShowPopularRecyclerViewHolder>() {

    private val tvShowPopularList = ArrayList<TvShowPopular>()
    fun setList(tvShowList: List<TvShowPopular>) {
        tvShowPopularList.clear()
        tvShowPopularList.addAll(tvShowList)
    }


    inner class TvShowPopularRecyclerViewHolder(private val binding : ItemListTvShowGridBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(tvSHowPopular : TvShowPopular){
                binding.tvTvShowTitle.text = tvSHowPopular.name
                binding.tvTvShowReleaseDate.text = tvSHowPopular.firstAirDate
                val tvSHowPosterUrl = "https://image.tmdb.org/t/p/w500${tvSHowPopular.posterPath}"
                Glide.with(binding.ivTvShowPoster.context)
                    .load(tvSHowPosterUrl)
                    .into(binding.ivTvShowPoster)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowPopularRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListTvShowGridBinding = ItemListTvShowGridBinding.inflate(layoutInflater, parent, false)
        return TvShowPopularRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowPopularRecyclerViewHolder, position: Int) {
        holder.bind(tvShowPopularList[position])
    }

    override fun getItemCount(): Int {
        return tvShowPopularList.size
    }
}