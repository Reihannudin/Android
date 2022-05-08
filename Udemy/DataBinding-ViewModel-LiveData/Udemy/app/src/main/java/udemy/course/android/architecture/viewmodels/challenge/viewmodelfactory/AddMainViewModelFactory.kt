package udemy.course.android.architecture.viewmodels.challenge.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.android.architecture.livedata.livesdata.AddLiveDataMainViewModel

class AddMainViewModelFactory (private val startingTotal : Int) : ViewModelProvider.Factory {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddLiveDataMainViewModel::class.java)) {
            return AddLiveDataMainViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
