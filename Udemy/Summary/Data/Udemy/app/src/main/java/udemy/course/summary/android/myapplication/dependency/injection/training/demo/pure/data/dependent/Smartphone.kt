package udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependent

import android.util.Log
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.Battery
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.MemoryCard
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.pure.data.dependencies.SimCard

class Smartphone(battery : Battery, simCard : SimCard, memoryCard : MemoryCard) {

    val myTag = "MYTAG"

    init{
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailablity()
        Log.i(myTag, "Smartphone Constructed created")
    }

    fun makeACallWithRecording(){
        Log.i(myTag, "Smartphone making a call")
    }
}