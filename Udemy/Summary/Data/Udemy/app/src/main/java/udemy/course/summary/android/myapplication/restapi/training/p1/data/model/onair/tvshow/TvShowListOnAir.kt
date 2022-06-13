package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowListOnAir(

    @SerializedName("results")
    val tvShowOnAirs: List<TvShowOnAir>
)