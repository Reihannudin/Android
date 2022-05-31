package udemy.course.summary.android.app.bindings.twoway

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayViewModel : ViewModel() {

    private val userName = MutableLiveData<String>()
    val userNameData: MutableLiveData<String>
        get() = userName

    init{
        userName.value = "Reihannudin"
    }

}
