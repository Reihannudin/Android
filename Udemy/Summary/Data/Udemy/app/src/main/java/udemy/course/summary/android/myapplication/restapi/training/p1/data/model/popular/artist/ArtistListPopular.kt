package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist


import com.google.gson.annotations.SerializedName

data class ArtistListPopular(

    @SerializedName("results")
    val artistPopulars: List<ArtistPopular>,

)