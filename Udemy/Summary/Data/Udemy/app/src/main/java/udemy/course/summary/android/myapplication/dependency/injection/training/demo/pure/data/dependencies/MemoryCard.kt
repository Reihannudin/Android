package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies

import android.util.Log

class MemoryCard {

    val myTag = "MYTAG"

    init{
        Log.i(myTag, "MemoryCard Constructed created")
    }

    fun getSpaceAvailablity(){
        Log.i(myTag, "Memory space available")
    }
}