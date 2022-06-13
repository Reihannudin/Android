package udemy.course.summary.android.myapplication.database.challenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tweet_table")
data class Tweet(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tweet_id")
    var id : Long,

    @ColumnInfo(name = "image_username")
    val image : Int,

    @ColumnInfo(name = "tweet_userName")
    var userName : String,

    @ColumnInfo(name = "tweet_text")
    var tweet : String
)
