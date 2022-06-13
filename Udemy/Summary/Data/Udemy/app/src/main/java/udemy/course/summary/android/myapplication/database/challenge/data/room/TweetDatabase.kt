package udemy.course.summary.android.myapplication.database.challenge.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import udemy.course.summary.android.myapplication.database.challenge.data.dao.TweetDao
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet
import udemy.course.summary.android.myapplication.database.training.data.dao.SubscriberDao
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber
import udemy.course.summary.android.myapplication.database.training.data.room.SubscriberDatabase

@Database(entities = [Tweet::class], version = 1)
abstract class TweetDatabase: RoomDatabase() {

    abstract fun tweetDao(): TweetDao

    companion object{
        @Volatile
        private var INSTANCE: TweetDatabase? = null
        fun getInstance(context : Context): TweetDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TweetDatabase::class.java ,
                        "tweet_table"
                    ).build()
                }
                return instance
            }
        }
    }
}