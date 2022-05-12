package udemy.course.android.myapplication.dagger.dependency

import android.util.Log
import javax.inject.Inject

class Processor @Inject constructor() {

    val Tag = "MyTag"

    init {
        Log.i(Tag, "processor constructed")
    }

    fun getProcessor() {
        Log.i(Tag, "Intel i7")
    }
}