package udemy.course.summary.android.myapplication.restapi.training.pt1.data.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import udemy.course.summary.android.myapplication.restapi.training.pt1.data.model.popular.artist.KnownFor

class ConvertersString {

        @TypeConverter
        fun fromString(value: String): List<String>? {
            val listType = object : TypeToken<List<String>>() {}.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun fromArrayList(list: List<String>?): String {
            return Gson().toJson(list)
        }

}