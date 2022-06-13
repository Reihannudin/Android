package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken


@Entity(tableName = "popular_tvshow")
data class TvShowPopular(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("origin_country")
    val originCountry: List<String>?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_name")
    val originalName: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("vote_count")
    val voteCount: Int?
)
