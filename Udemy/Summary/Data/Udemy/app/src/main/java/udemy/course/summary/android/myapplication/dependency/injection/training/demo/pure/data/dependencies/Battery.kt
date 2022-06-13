package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies

import android.util.Log

class Battery {

    val myTag = "MYTAG"

    init {
        Log.i(myTag, "Battery Constructed created")
    }

    fun getPower(){
        Log.i(myTag, "Battery Power is available")
    }
}