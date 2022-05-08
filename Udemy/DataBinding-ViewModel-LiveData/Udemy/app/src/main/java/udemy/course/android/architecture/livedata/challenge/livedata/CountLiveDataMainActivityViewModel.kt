package udemy.course.android.architecture.livedata.challenge.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountLiveDataMainActivityViewModel: ViewModel() {
    private var count = MutableLiveData<Int>()
    val countLiveData: MutableLiveData<Int>
        get() = count

    fun getCount() : Int {
        return count.value ?: 0
    }

    fun IncrementCount(): Int {
//        make increment
        count.value = getCount() + 1
        return getCount()
    }

    fun decrementCount(): Int {
//        make decrement
        count.value = getCount() - 1
        return getCount()
    }

}