package com.example.roomdemo

import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdemo.db.Subscriber
import com.example.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.launch



class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        if(inputName.value == null){
            statusMessage.value = Event("Please enter subscriber name")
        } else if(inputEmail.value == null){
            statusMessage.value = Event("Please enter subscriber email")
        } else if (EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()){
            statusMessage.value = Event("Please enter valid email")
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

    fun clearAllOrDelete(){
      if (isUpdateOrDelete){
          delete(subscriberToUpdateOrDelete)
      }else{
          clearAll()
      }
    }

    fun insert(subscriber: Subscriber)= viewModelScope.launch {
            val numIdInsert = repository.insert(subscriber)

            if(numIdInsert >- 1){
               statusMessage.value = Event("Subscriber insert successfully")
            }else{
               statusMessage.value = Event("Error insert subscriber")
            }
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        val numIdUpdate = repository.update(subscriber)

        if (numIdUpdate > 0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$numIdUpdate Row update successfully")
        } else{
            statusMessage.value = Event("Error 0 update subscriber")
        }
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        val numIdDelete = repository.delete(subscriber)
        if (numIdDelete > 0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$numIdDelete Row delete successfully")
        } else{
            statusMessage.value = Event("Error 0 delete subscriber")
        }
    }

    private fun clearAll()= viewModelScope.launch {
        val numIdClearAll = repository.deleteAll()
        if (numIdClearAll > 0){
            statusMessage.value = Event("$numIdClearAll Subscriber clear all successfully")
        } else{
            statusMessage.value = Event("Error 0 clear all subscriber")
        }
    }

    fun initUpdateOrDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

}