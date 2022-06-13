package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies

import android.util.Log
import javax.inject.Inject

class Processor @Inject constructor(private val processorProvider: ProcessorProvider) {

    val myTag = "MYTAG"

    init {
        Log.i(myTag, "Processor Constructed created")
    }

    fun getProcessorSpec(){
        processorProvider.getProcessorName()
        processorProvider.getProcessorSpeed()
        processorProvider.getProcessorCore()
    }
}