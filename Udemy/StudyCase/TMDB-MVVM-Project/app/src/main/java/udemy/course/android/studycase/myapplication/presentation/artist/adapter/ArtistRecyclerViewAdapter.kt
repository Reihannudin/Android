package udemy.course.android.studycase.myapplication.presentation.artist.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udemy.course.android.studycase.myapplication.R
import udemy.course.android.studycase.myapplication.data.model.artist.Artist
import udemy.course.android.studycase.myapplication.databinding.ItemListArtistBinding

class ArtistRecyclerViewAdapter : RecyclerView.Adapter<ArtistRecyclerViewAdapter.ArtistViewHolder>() {

    private val artistList = ArrayList<Artist>()
    fun setList(artist: List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }

    inner class ArtistViewHolder(val binding: ItemListArtistBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(artist:Artist){
            binding.tvArtistTitle.text = artist.name
            binding.tvArtistPopularity.text = artist.popularity.toString()

//            define poster artist
            val artistPosterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(binding.ivArtistPoster.context)
                .load(artistPosterUrl)
                .into(binding.ivArtistPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListArtistBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_list_artist, parent, false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}