package udemy.course.android.myapplication.concept.dependency

import android.util.Log

class Battery {

    val Tag = "MyTag"

    init{
        Log.i(Tag,"Battery Constructed")
    }

    fun getPower() {
        Log.i(Tag,"Battery Power is available")
    }
}