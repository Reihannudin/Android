package udemy.course.android.myapplication.withouthilt

import android.app.Application

class DataApp : Application(){
    lateinit var dataComponent: DataComponent
    override fun onCreate() {
//        dataComponent = DaggerDataComponent.builder()
//            .build()
        super.onCreate()
    }
}