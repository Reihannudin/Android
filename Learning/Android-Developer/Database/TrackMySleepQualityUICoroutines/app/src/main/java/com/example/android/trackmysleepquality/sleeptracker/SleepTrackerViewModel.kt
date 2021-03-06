/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.formatNights
import kotlinx.coroutines.launch

/**
 * ViewModel for SleepTrackerFragment.
 */

class SleepTrackerViewModel(
        val database: SleepDatabaseDao,
        application: Application) : AndroidViewModel(application) {

        private val nights = database.getAllNights()

        val nightString = Transformations.map(nights) { nights ->
            formatNights(nights, application.resources)
        }

        //      binding using live data
        private val tonight = MutableLiveData<SleepNight?>()
//      init block
        init {
                initializeTonight()
        }

//        make functionn initialize tonight
        private fun initializeTonight() {
                viewModelScope.launch {
                        tonight.value = getTonightFromDatabase()
                }
        }

//        make private suspen function getTonightFromDatabase
        private suspend fun getTonightFromDatabase(): SleepNight? {
                var night = database.getTonight()
                if (night?.endTimeMillis != night?.startTimeMillis){
                        night = null
                }
                return night
            }


//        Add a click handler for the Start button
        //make fun onStartTracking
        fun onStartTracking(){
        //  launch coroutines
                viewModelScope.launch {
                        val newNight = SleepNight() //  create new night
                        insert(newNight) //  insert new night
                        tonight.value = getTonightFromDatabase() //  update tonight
                }
        }
//        define fun insert
        private suspend fun insert(night: SleepNight) {
                database.insert(night)
        }

//        Add click handler for stop button
//        make fun onStopTracking()
        fun onStopTracking(){
//                launch coroutines
                viewModelScope.launch {
                        val oldNight = tonight.value ?: return@launch
                        oldNight.endTimeMillis = System.currentTimeMillis() //  update end time
                        update(oldNight) //  update night
                }
        }
//        define update function
        private suspend fun update(night: SleepNight) {
                database.update(night)
        }

//        Add click handler for clean button
//        make fun onClear()
        fun onClear(){
//                launch coroutines
                viewModelScope.launch {
                        clear()
                        tonight.value = null
                }
        }
//        define clear function
        private suspend fun clear() {
                database.clear()
        }
}



