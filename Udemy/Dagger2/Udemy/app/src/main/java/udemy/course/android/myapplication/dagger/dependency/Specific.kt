package udemy.course.android.myapplication.dagger.dependency

import android.util.Log
import javax.inject.Inject

class Specific @Inject constructor(private val processor: Processor, private val memory: MemoryRam, private val hardisk: Hardisk) {

    private val Tag = "MyTag"
    init{
        Log.i(Tag,"Specific constructed")
    }

    fun getSpec(){
        processor.getProcessor()
        memory.getMemoryRam()
        hardisk.getHardisk()
    }
}


