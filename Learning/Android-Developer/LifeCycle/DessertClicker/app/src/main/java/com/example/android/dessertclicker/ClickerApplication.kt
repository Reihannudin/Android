package com.example.android.dessertclicker

import android.app.Application
import timber.log.Timber

// extend class application
class ClickerApplication : Application() {
//    make fun onCreate
    override fun onCreate() {
        super.onCreate()

//    initialize timber
    Timber.plant(Timber.DebugTree())
    }
}