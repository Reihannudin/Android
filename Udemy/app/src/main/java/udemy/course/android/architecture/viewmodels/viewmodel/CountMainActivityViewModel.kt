package udemy.course.android.architecture.viewmodels.viewmodel

import androidx.lifecycle.ViewModel

class CountMainActivityViewModel: ViewModel() {
    private var count : Int = 0

    fun getCount() : Int {
        return count
    }

    fun IncrementCount(): Int {
        return ++count
    }

    fun DecrementCount(): Int {
        return --count
    }

}