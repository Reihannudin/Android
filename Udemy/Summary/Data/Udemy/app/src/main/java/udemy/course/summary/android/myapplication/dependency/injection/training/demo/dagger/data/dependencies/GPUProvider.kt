package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies

import android.util.Log
import javax.inject.Inject

class GPUProvider @Inject constructor() {

    val myTag = "MYTAG"

    init{
        Log.i(myTag,"GPU Constructed created")
    }

    fun getGPUProvider(){
        Log.i(myTag,"NVDIA GPU Provider")
    }

}