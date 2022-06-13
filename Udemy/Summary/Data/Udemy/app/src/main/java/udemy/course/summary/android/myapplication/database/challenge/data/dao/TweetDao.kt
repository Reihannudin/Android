package udemy.course.summary.android.myapplication.database.challenge.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet

@Dao
interface TweetDao {

    @Insert
    suspend fun insertTweet(tweet: Tweet) : Long

    @Update
    suspend fun updateTweet(tweet: Tweet)

    @Delete
    suspend fun deleteTweet(tweet: Tweet)

    @Query("DELETE FROM tweet_table")
    suspend fun deleteAllTweets()

    @Query("SELECT * FROM tweet_table")
    fun getALlTweets() : LiveData<List<Tweet>>
}