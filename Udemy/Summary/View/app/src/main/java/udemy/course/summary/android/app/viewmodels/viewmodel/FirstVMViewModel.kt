package udemy.course.summary.android.app.viewmodels.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class FirstVMViewModel(newPriceHamburger : Double) : ViewModel() {

    private var money = MutableLiveData<Double>()
    val moneyLiveData : LiveData<Double>
        get() = money

    private var priceHamburger : Double = 1.65
    private var priceCola : Double = 0.50

    init {
        money.value = 0.0
        priceHamburger = newPriceHamburger
    }

//    fun getMoney() : Double {
//        return money
//    }

    fun getPriceHamburger() : Double {
        return priceHamburger
    }

    fun getPriceCola(): Double {
        return priceCola
    }

    fun setTopUpMoney(input : Double){
        money.value = (money.value)?.plus(input)
    }

    fun buyItemHamburger(priceHamburger: Double = getPriceHamburger()){
        money.value = (money.value)?.minus(priceHamburger)
    }

    fun buyItemCola(priceCola: Double = getPriceCola()){
        money.value = (money.value)?.minus(priceCola)
    }

}