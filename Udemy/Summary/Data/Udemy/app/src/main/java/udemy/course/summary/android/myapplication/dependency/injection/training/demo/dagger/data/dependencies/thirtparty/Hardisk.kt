package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty

import android.util.Log
import javax.inject.Inject

class Hardisk {

    val myTag = "MYTAG"

    init {
        Log.i(myTag, "RAM Constructed created")
    }

    fun getSpaceHardisk(){
        Log.i(myTag, "498GB space in Hardisk available")
    }
}