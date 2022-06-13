package udemy.course.summary.android.myapplication.dependency.injection.training.demo.dagger.data.dependencies

import android.util.Log
import javax.inject.Inject

class ProcessorProvider @Inject constructor() {

    val myTag = "MYTAG"

    init{
        Log.i(myTag,"Processor Constructed created")
    }

    fun getProcessorName(){
        Log.i(myTag,"Processor Name : INTEL i7")
    }

    fun getProcessorSpeed(){
        Log.i(myTag,"Processor Speed : 2.9GHz")
    }

    fun getProcessorCore(){
        Log.i(myTag,"Processor Core : 8")
    }

}
