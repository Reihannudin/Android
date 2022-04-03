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

package com.example.android.devbyteviewer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

// Implementing Database using Room

// make Dao (Data Access Object) available to Room
@Dao
interface VideoDao {

    @Query("select * from databasesvideo")
//    create a method called getVideos() to fetch all videos from database
    fun getVideos(): LiveData<List<DatabasesVideo>>


//    define  function InsertAll
    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    insert all videos into database
    fun insertAll(videos: List<DatabasesVideo>)
}


//annotation for Room database
// make abstract VideosDatabase class available to Room
@Database(entities = [DatabasesVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
//    make VideoDao available to Room
    abstract val videoDao: VideoDao
}


//make private lateInit Instance of VideosDatabase
private lateinit var INSTANCE : VideosDatabase
//make a synchronized function to get instance of VideosDatabase
fun getDatabase(context: Context): VideosDatabase{
    synchronized(VideosDatabase::class.java){
//        if instance is not initialized then initialize it
        if(!::INSTANCE.isInitialized){
//            create a new instance of VideosDatabase
            INSTANCE = Room.databaseBuilder((context.applicationContext),
                    VideosDatabase::class.java,
                    "videos").build()
        }
    }
//    return instance of VideosDatabase
    return INSTANCE
}
