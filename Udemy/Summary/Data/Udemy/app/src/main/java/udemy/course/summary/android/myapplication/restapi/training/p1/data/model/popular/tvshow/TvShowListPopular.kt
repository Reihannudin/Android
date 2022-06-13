package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowListPopular(

    @SerializedName("results")
    val tvShowPopulars: List<TvShowPopular>

)