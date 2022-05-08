package udemy.course.android.myapplication.async

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import udemy.course.android.myapplication.R
import udemy.course.android.myapplication.databinding.ActivityAsyncAwaitBinding

class AsyncAwaitActivity: AppCompatActivity() {

    private val Tag = "MyTag"
    private lateinit var binding : ActivityAsyncAwaitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_async_await)

        CoroutineScope(Main).launch {
            Log.i(Tag, "Calculation started....")

            val stock1 = async(IO) {
                getStock1()
            }

            val stock2 = async(IO) {
                getStock2()
            }

            val total = stock1.await() + stock2.await()
            Toast.makeText(this@AsyncAwaitActivity, "Total: $total", Toast.LENGTH_SHORT).show()
        }

    }

    private suspend fun getStock1 (): Int {
        delay(10000)
        Log.i(Tag,"Stock 1 return")
        return 55000
    }

    private suspend fun getStock2 (): Int {
        delay(8000)
        Log.i(Tag,"Stock 2 return")
        return 35000
    }
}