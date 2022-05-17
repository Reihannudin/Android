package udemy.course.android.studycase.myapplication.presentation.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.data.model.tvshow.TvShow
import udemy.course.android.studycase.myapplication.databinding.ItemListTvShowBinding

class TvShowRecyclerViewAdapter : RecyclerView.Adapter<TvShowRecyclerViewAdapter.TvShowViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()
    fun setList(tvShow : List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }

    inner class TvShowViewHolder(val binding : ItemListTvShowBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(tvShow:TvShow){
            binding.tvTvShowTitle.text = tvShow.name
            binding.tvTvShowOveriview.text = tvShow.overview
            binding.tvTvshowReleaseDate.text = tvShow.firstAirDate

//            define poster API
            val tvShowPosterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
            Glide.with(binding.ivTvShowPoster.context)
                .load(tvShowPosterUrl)
                .into(binding.ivTvShowPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListTvShowBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_list_tv_show, parent, false
        )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}