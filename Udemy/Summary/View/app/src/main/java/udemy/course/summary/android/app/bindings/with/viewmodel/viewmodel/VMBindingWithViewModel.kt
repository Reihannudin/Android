package udemy.course.summary.android.app.bindings.with.viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VMBindingWithViewModel: ViewModel() {

    private var _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    init {
        _counter.value = 0
    }

    fun increment() {
        _counter.value = _counter.value?.plus(1)
    }
}