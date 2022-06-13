package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies

import android.util.Log

class ServiceProvider {

    val myTag = "MYTAG"

    init{
        Log.i(myTag,"ServiceProvider Constructed created")
    }

    fun getServiceProvider(){
        Log.i(myTag,"ServiceProvider connected")
    }


}