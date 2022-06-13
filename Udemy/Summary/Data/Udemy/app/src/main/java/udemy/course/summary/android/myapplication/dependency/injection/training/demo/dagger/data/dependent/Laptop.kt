package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependent

import android.util.Log
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.GPU
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.thirtparty.Hardisk
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.Processor
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies.interfaces.Ram
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Laptop @Inject constructor(ram: Ram, gpu: GPU, processor: Processor, hardisk: Hardisk) {

    val myTag = "MYTAG"

    init{
        ram.getRamSize()
        gpu.getNameGPU()
        processor.getProcessorSpec()
        hardisk.getSpaceHardisk()
        Log.i(myTag, "Laptop Constructed created")
    }

    fun makeACallWithRecording(){
        Log.i(myTag, "Laptop making a call")
    }
}