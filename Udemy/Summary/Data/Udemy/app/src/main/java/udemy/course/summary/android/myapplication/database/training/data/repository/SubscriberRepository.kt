package udemy.course.summary.android.myapplication.database.training.data.repository

import udemy.course.summary.android.myapplication.database.training.data.dao.SubscriberDao
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber

//define DAO as a property of the repository
class SubscriberRepository(private val dao : SubscriberDao) {

//    get all subscribers
    val subscriber = dao.getAllSubscribers()

//    insert subscriber
    suspend fun insert(subscriber : Subscriber){
        dao.insertSubscriber(subscriber)
    }

//    update subscribe
    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

//    delete subscriber
    suspend fun delete(subscriber : Subscriber){
        dao.deleteSubscriber(subscriber)
    }

//    deleteAll subscribers
    suspend fun deleteAll(){
        dao.deleteAllSubscribers()
    }

}