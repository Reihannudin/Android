package programmerzamannow.android_basic

import android.app.Application
import android.util.Log

//for make aplication class you should extend Application class
class MyApplication : Application(){
    override fun onCreate() { //onCreate() method is called when the application is starting
        super.onCreate() //super keyword is used to call the method of the parent class
        Log.i("APP","Application Created")
    }
}