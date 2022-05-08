package udemy.course.android.architecture.more.viewmodelxdatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VmXDbXLdViewModel : ViewModel() {

    private val startnumber = MutableLiveData<Int>()
    val startnumberLiveData : MutableLiveData<Int>
    get() = startnumber


    fun getStartNumber(): Int {
        return startnumber.value ?: 0
    }

    fun addStartNumber(): Int {
        startnumber.value = getStartNumber() + 1
        return getStartNumber()
    }

    fun minusStartNumber(): Int {
        startnumber.value =getStartNumber()  - 1
        return getStartNumber()
    }

}