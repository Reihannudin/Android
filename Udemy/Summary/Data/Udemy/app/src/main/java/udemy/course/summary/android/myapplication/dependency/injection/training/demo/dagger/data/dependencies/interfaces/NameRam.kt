package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.interfaces

import android.util.Log
import javax.inject.Inject

class NameRam @Inject constructor() : Ram{
    override fun getRamSize() {
        Log.i("MYTAG", "Ram name : Samsung 12GB")
    }
}