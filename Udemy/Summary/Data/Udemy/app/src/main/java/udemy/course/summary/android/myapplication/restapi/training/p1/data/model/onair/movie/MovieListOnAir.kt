package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie


import com.google.gson.annotations.SerializedName

data class MovieListOnAir(

    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("results")
    val movieOnAirs: List<MovieOnAir>,

)