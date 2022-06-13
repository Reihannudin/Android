package udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.database.challenge.data.repository.TweetRepository
import udemy.course.summary.android.myapplication.database.challenge.view.viewmodel.TweetViewModel

class TweetViewModelFactory (private val repository: TweetRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TweetViewModel::class.java)) {
            return TweetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}