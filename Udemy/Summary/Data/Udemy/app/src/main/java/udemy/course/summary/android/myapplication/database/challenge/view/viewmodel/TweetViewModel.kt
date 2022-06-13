package udemy.course.summary.android.myapplication.database.challenge.view.viewmodel

import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import udemy.course.summary.android.myapplication.R
import udemy.course.summary.android.myapplication.database.challenge.data.model.Tweet
import udemy.course.summary.android.myapplication.database.challenge.data.repository.TweetRepository
import udemy.course.summary.android.myapplication.database.training.Event
import udemy.course.summary.android.myapplication.databinding.FragmentAddBinding


class TweetViewModel(private val repository: TweetRepository): ViewModel() {

    private lateinit var binding : FragmentAddBinding

    val tweet = repository.tweet
    val inputTweet = MutableLiveData<String?>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun btnCreateTweet(){
        if (inputTweet.value == null) {
            statusMessage.value = Event("Tweet cannot be empty")
        }else if (inputTweet.value!!.isBlank()) {
            statusMessage.value = Event("Tweet cannot be empty")
        }else{
            val tweet = inputTweet.value!!
            insert(Tweet(0, R.drawable.suga,"reihannudin",tweet))
            inputTweet.value = null
        }
    }

    fun btnDiscard(){
        if (inputTweet.value == null) {
            statusMessage.value = Event("Tweet cannot discard when empty")
        }else if (inputTweet.value!!.isNotBlank()){
            inputTweet.value = ""
        }else{
            inputTweet.value
        }
    }


    fun insert(tweet: Tweet) = viewModelScope.launch {
        repository.insert(tweet)
    }

    fun update(tweet: Tweet) = viewModelScope.launch {
        repository.update(tweet)
    }

    fun delete(tweet: Tweet) = viewModelScope.launch {
        repository.delete(tweet)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}