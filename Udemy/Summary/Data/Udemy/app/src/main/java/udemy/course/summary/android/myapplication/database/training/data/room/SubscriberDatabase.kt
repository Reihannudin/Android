package udemy.course.summary.android.myapplication.database.training.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import udemy.course.summary.android.myapplication.database.training.data.dao.SubscriberDao
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber

// define the database name and version
//use abstract class to define the roomDatabase
@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase(){

//    define abstract function subscriberDao
    abstract fun subscriberDao(): SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE: SubscriberDatabase? = null
        fun getInstance(context : Context):SubscriberDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java ,
                        "subscriber_table"
                    ).build()
                }
                return instance
            }
        }
    }
}

