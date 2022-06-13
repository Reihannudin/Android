package udemy.course.summary.android.myapplication.database.training.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber

@Dao
interface SubscriberDao {

//    insert function
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

//    update function
    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

//    delete function
    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

//    delete all function
    @Query("DELETE FROM subscriber_table")
    suspend fun deleteAllSubscribers()

//    get all function
    @Query("SELECT * FROM subscriber_table")
    fun getAllSubscribers(): LiveData<List<Subscriber>>
}