package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.movie


import com.google.gson.annotations.SerializedName

data class MovieListPopular(

    @SerializedName("results")
    val moviePopulars: List<MoviePopular>
)