package udemy.course.android.architecture.viewmodels.challenge

import androidx.lifecycle.ViewModel

class AddMainViewModel(startingTotal : Int) : ViewModel() {

    private var total = 0

    init {
        total = startingTotal
    }

     fun getTotal(): Int{
         return total
     }

     fun setAddTotal(input : Int){
         total += input
     }

    fun setMinTotal(input : Int){
            total -= input
    }

    fun clearTotal(){
        if(total != 0){
            total = 0
        }
    }


}