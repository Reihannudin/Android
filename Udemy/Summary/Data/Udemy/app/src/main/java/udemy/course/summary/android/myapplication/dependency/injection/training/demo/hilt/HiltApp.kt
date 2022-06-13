package udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt

import android.app.Application
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data.component.DaggerDataHiltComponent
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data.component.DataHiltComponent

class HiltApp : Application() {
    lateinit var dataCompponent : DataHiltComponent
    override fun onCreate() {
        dataCompponent = DaggerDataHiltComponent.builder().build()
        super.onCreate()
    }
}