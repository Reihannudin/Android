package udemy.course.summary.android.myapplication.database.training.view.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.myapplication.database.training.data.repository.SubscriberRepository
import udemy.course.summary.android.myapplication.database.training.view.viewmodel.SubscriberViewmodel

class SubscriberViewModelFactory(private val repository: SubscriberRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewmodel::class.java)) {
            return SubscriberViewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}