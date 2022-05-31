package udemy.course.summary.android.app.viewmodels.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import udemy.course.summary.android.app.viewmodels.viewmodel.FirstVMViewModel

class FirstVMViewModelFactory(private val newPriceHamburger : Double): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FirstVMViewModel::class.java)){
            return FirstVMViewModel(newPriceHamburger) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}