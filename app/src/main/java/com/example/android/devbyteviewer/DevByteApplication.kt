/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.devbyteviewer

import android.app.Application
import android.os.Build
import androidx.work.*
import com.example.android.devbyteviewer.work.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Override application to setup background work via WorkManager
 */
class DevByteApplication : Application() {

//    make coroutines Scope and define Dispatchers.Default
    val applicationScope = CoroutineScope(Dispatchers.Default)

    /**
     * onCreate is called before the first screen is shown to the user.
     *
     * Use it to setup any background tasks, running expensive setup operations in a background
     * thread to avoid delaying app start.
     */
    override fun onCreate() {
        super.onCreate()
//        call method
        delayInit()
    }

    /**
     * Setup WorkManager background job to 'fetch' new network data daily.
     */

//    define WorkManager
    private fun setupRecurringWork() {
//        Add Constraint object and set one constraint
        val constraints = Constraints.Builder()
//            adds a network type constraint to the constraintsobject.
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true) // requires the device to be plugged in
            .setRequiresCharging(true) // requires the device to be charging
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // requires the device > API 23
                    setRequiresDeviceIdle(true)
                }
            }
            .build()

//        make requestWorker and passing class RefresheDataWorker

//        with Time Refresh 1 Day
//        val repreatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
//            .build()

//        With  time Refresh 15 Minutes
        val repreatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

//        schedule work
        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repreatingRequest
        )
    }

//  add function Delayinit to statr Coroutines
    private fun delayInit() {
//        start coroutines
    applicationScope.launch {
//        make Timber
        Timber.plant(Timber.DebugTree())
//        setup work
        setupRecurringWork()
        }
    }
}
