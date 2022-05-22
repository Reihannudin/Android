package udemy.course.android.myapplication.withhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltDataApp : Application()
//    lateinit var hiltDataComponent: HiltDataComponent
//    override fun onCreate() {
//        hiltDataComponent = DaggerHiltDataComponent.builder()
//            .build()
//        super.onCreate()
//    }
