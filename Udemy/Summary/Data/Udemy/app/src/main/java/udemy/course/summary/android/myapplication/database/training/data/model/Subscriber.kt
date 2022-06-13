package udemy.course.summary.android.myapplication.database.training.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//add Entity annotation for Room to recognize this class as a table
@Entity(tableName = "subscriber_table")
data class Subscriber(

    //add primary key for Room to recognize this field as a primary key
    //add autoGenerate to true to generate a primary key for us
    @PrimaryKey(autoGenerate = true)
    //add column annotation to specify the name of the column
    @ColumnInfo(name = "subscriber_id")
    var id : Int,

    @ColumnInfo(name = "subscriber_name")
    var name : String,

    @ColumnInfo(name = "subscriber_email")
    var email : String

    )
