package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies

import android.util.Log
import javax.inject.Inject

class GPU @Inject constructor(private val gpuProvider: GPUProvider) {

    val myTag = "MYTAG"

    init {
        Log.i(myTag, "GPU Constructed created")
    }

    fun getNameGPU(){
        gpuProvider.getGPUProvider()
    }

}