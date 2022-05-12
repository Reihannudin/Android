package udemy.course.android.myapplication.concept.dependency

import android.util.Log

class MemoryCard {

    val Tag = "MyTag"

    init {
        Log.i(Tag, "Memory Card Constructed")
    }

    fun getSpaceAvailable() {
        Log.i(Tag, "Memory Card Space Available")
    }
}