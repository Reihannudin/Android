package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String?,
    @SerializedName("minimum")
    val minimum: String?
)