package udemy.course.android.architecture.more.challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChallengeViewModel: ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    val inputText = MutableLiveData<String>()

    init {
        _count.value = count.value
    }

    fun setAddCount() {
        val input : Int? = inputText.value?.toInt()
        _count.value = (_count.value)?.plus(input!!)
    }
}
