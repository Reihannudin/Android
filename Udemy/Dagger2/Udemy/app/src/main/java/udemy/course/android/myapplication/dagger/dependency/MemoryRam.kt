package udemy.course.android.myapplication.dagger.dependency

import android.util.Log
import javax.inject.Inject

class MemoryRam @Inject constructor(){

    val Tag = "MyTag"

    init {
        Log.i(Tag, "Memory Ram constructed")
    }

    fun getMemoryRam() {
        Log.i(Tag, "Memory Ram 8 GB")
    }
}