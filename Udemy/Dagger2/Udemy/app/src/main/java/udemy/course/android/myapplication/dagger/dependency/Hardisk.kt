package udemy.course.android.myapplication.dagger.dependency

import android.util.Log
import javax.inject.Inject

class Hardisk @Inject constructor() {

    val Tag = "MyTag"

    init{
        Log.i(Tag, "Hardisk constructed")
    }

    fun getHardisk(){
        Log.i(Tag, "Hardisk SSD Samsung 1TB")
    }
}

