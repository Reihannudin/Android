package udemy.course.android.architecture.livedata.livesdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.coroutines.EmptyCoroutineContext.plus

class AddLiveDataMainViewModel(startingTotal : Int) : ViewModel() {

//    define a live data variable
    private var total = MutableLiveData<Int>()
//    encapsulate the starting total
    var totalLiveData : LiveData<Int> = total

    init {
        total.value = startingTotal
    }

     fun getTotal(): Int? {
         return total.value
     }

     fun setAddTotal(input : Int){
         total.value = (total.value)?.plus(input)
     }

    fun setMinTotal(input : Int){
            total.value = (total.value)?.minus(input)
    }

    fun clearTotal(){
        if(total.value != 0){
            total.value = 0
        }
    }


}