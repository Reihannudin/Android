package udemy.course.android.myapplication.concurrency.structured

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManagerStructured {
    var count = 0
    lateinit var defered : Deferred<Int>

    suspend fun getTotalUsers(): Int {
        coroutineScope {
            launch {
                delay(1000)
                count = 50
            }

            defered = async(IO) {
                delay(3000)
                return@async 100
            }
        }
        return count + defered.await()
    }

}