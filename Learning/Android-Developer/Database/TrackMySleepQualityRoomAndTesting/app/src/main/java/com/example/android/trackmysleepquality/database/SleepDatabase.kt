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

package com.example.android.trackmysleepquality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//make Room Database
//add annotation database
//make abstract class and extend RoomDatabase
@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase(){
//    make abstract method to get instance of SleepDatabaseDao
    abstract val sleepDatabaseDao: SleepDatabaseDao
//    add companion object
    companion object{
//        Declarate private variable nullable INSTANCE
//        volatile annotations will never be cached, and all writes and reads will be made to and from main memory
        @Volatile
        private var INSTANCE: SleepDatabase? = null
//    make fun getInstance extend SleepDatabase
        fun getInstance(context: Context): SleepDatabase? {
//            add synchronized to make sure only one thread can access this method at a time
            synchronized(this){
                var instance = INSTANCE //make variable instance get INSTANCE
                if (instance == null) { // check if instance is null
                    instance = Room.databaseBuilder( //make instance of Room.databaseBuilder
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration() //make it destructive
                        .build() //build
                    INSTANCE = instance //make INSTANCE equal to instance
                }
                    return instance // return instance
                }
            }
        }
    }
