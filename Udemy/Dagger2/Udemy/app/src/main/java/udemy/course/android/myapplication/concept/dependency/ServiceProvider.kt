package udemy.course.android.myapplication.concept.dependency

import android.util.Log

class ServiceProvider {

    val Tag = "MyTag"

    init{
        Log.i(Tag, "Service provider construted")
    }

    fun getServiceProvider(){
        Log.i(Tag, "Service provider connected")
    }
}