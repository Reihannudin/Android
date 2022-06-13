package udemy.course.summary.android.myapplication.database.challenge.data.repository

import udemy.course.summary.android.myapplication.database.challenge.data.dao.TweetDao
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet

class TweetRepository(private val dao : TweetDao) {

    val tweet = dao.getALlTweets()

    suspend fun insert(tweet : Tweet) {
        dao.insertTweet(tweet)
    }

    suspend fun update(tweet : Tweet) {
        dao.updateTweet(tweet)
    }

    suspend fun delete(tweet : Tweet) {
        dao.deleteTweet(tweet)
    }

    suspend fun deleteAll() {
        dao.deleteAllTweets()
    }
}