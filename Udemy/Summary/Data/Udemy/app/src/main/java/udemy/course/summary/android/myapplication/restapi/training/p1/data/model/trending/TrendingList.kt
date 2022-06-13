package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending


import com.google.gson.annotations.SerializedName

data class TrendingList(

    @SerializedName("results")
    val trendings: List<Trending>,

)