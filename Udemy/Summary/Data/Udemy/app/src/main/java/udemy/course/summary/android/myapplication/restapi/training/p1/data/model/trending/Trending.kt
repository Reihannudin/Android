package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.trending


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "trending_film")
data class Trending(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @SerializedName("media_type")
    val mediaType: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("origin_country")
    val originCountry: List<String>?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_name")
    val originalName: String?,

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