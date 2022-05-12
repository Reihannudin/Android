package udemy.course.android.myapplication.concept.dependency

import android.util.Log

class SmartPhone(val battery: Battery, val memoryCard: MemoryCard, val simCard: SIMCard) {

    val Tag = "MyTag"

    init {
        battery.getPower()
        memoryCard.getSpaceAvailable()
        simCard.getConnection()
        Log.i(Tag, "SmartPhone created")
    }

    fun makeACall(){
        Log.i(Tag, "Calling...")
    }
}