package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.onair.movie


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "onair_movie")
data class MovieOnAir(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("vote_count")
    val voteCount: Int?
)