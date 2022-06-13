package udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

@Entity(tableName = "popular_artist")
data class ArtistPopular(

    @PrimaryKey
    @SerializedName("gender")
    val gender: Int?,

    @SerializedName("id")
    val id: Int,

    @SerializedName("known_for")
    val knownFor: List<KnownFor>,

    @SerializedName("name")
    val name: String?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("profile_path")
    val profilePath: String?
)

class PopularArtistKnowForTypeConverter{
    @TypeConverter
    fun toString(data: String?): List<KnownFor>? {
        return data?.let {
            val listType = object : TypeToken<List<KnownFor>>() {}.type
            Gson().fromJson(it, listType)
        }
    }

    @TypeConverter
    fun fromList(list: List<KnownFor>?): String? {
        return Gson().toJson(list)
    }
}
