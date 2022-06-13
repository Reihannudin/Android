package udemy.course.summary.android.myapplication.database.training.view.viewmodel

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import udemy.course.summary.android.myapplication.database.training.Event
import udemy.course.summary.android.myapplication.database.training.data.model.Subscriber
import udemy.course.summary.android.myapplication.database.training.data.repository.SubscriberRepository

class SubscriberViewmodel(private val repository: SubscriberRepository) : ViewModel() {

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val saveOrUpdateBtn = MutableLiveData<String>()
    val deleteOrDeleteAllBtn = MutableLiveData<String>()

    val subscriber = repository.subscriber

    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateBtn.value = "Save"
        deleteOrDeleteAllBtn.value = "Delete All"
    }

    fun saveOrUpdate(){
        if(inputName.value == null){
            statusMessage.value = Event("Please enter subscriber name")
        } else if(inputEmail.value == null){
            statusMessage.value = Event("Please enter subscriber email")
        }else{
            if (isUpdateOrDelete){
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            }else{
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0,name,email))
                inputName.value = null
                inputEmail.value = null

            }
        }
    }

    fun deleteOrDeleteAll(){
        if (isUpdateOrDelete){
            delete(subscriberToUpdateOrDelete)
        }else{
            deleteAll()
        }
    }


    fun insert(subscriber: Subscriber)= viewModelScope.launch {
        repository.insert(subscriber)

//        if(numIdInsert > 1){
//            statusMessage.value = Event("Subscriber insert successfully")
//        }else{
//            statusMessage.value = Event("Error insert subscriber")
//        }
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)

//        if (numIdUpdate > 0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateBtn.value = "Save"
            deleteOrDeleteAllBtn.value = "Delete All"
//            statusMessage.value = Event("$numIdUpdate Row update successfully")
//        } else{
//            statusMessage.value = Event("Error 0 update subscriber")
//        }
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
//        if (numIdDelete > 0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateBtn.value = "Save"
            deleteOrDeleteAllBtn.value = "Delete All"
//            statusMessage.value = Event("$numIdDelete Row delete successfully")
//        } else{
//            statusMessage.value = Event("Error 0 delete subscriber")
//        }
    }

    private fun deleteAll()= viewModelScope.launch {
        repository.deleteAll()
//        if (numIdClearAll > 0){
//            statusMessage.value = Event("$numIdClearAll Subscriber clear all successfully")
//        } else{
//            statusMessage.value = Event("Error 0 clear all subscriber")
//        }
    }

    fun initUpdateOrDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateBtn.value = "Update"
        deleteOrDeleteAllBtn.value = "Delete"
    }

}
