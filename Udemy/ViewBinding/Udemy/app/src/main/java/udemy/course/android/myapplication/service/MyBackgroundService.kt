package udemy.course.android.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : Service() {

    init{
        Log.i(Tag,"Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(Tag,"Service has been started")
        val name = intent?.getStringExtra(MyBackgroundService.NAME)
        val age = intent?.getIntExtra(AGE,0)

        Log.i(Tag,"Service has been started with name: $name and age: $age")
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onDestroy() {
        Log.i(Tag,"Service has been destroyed")
        super.onDestroy()
    }

    companion object{
        const val Tag = "MyTag"
        const val NAME = "NAME"
        const val AGE = "AGE"
    }
}