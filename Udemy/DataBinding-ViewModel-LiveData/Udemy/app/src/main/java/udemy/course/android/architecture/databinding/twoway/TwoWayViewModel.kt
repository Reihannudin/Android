package udemy.course.android.architecture.databinding.twoway

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayViewModel: ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: MutableLiveData<String>
        get() = _name

    init {
        _name.value = "Username"
    }
}