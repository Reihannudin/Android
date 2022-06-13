package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies

import android.util.Log

class SimCard(private val serviceProvider : ServiceProvider) {

    val myTag = "MYTAG"

    init {
        Log.i( myTag, "SimCard constructed created")
    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }

}