package udemy.course.android.myapplication.concept.dependency

import android.util.Log

class SIMCard(private val serviceProvider: ServiceProvider) {

//    field injection
//    lateinit var serviceProvider: ServiceProvider

    val Tag = "MyTag"

    init {
        Log.i(Tag, "SIM Card Constructed")
    }

////    Methode Injection
//    fun setServiceProvider(serviceProvider: ServiceProvider) {
//        this.serviceProvider = serviceProvider
//    }


    fun getConnection(){
        serviceProvider.getServiceProvider()
    }

}