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

package com.example.android.devbyteviewer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.devbyteviewer.database.VideosDatabase
import com.example.android.devbyteviewer.database.asDomainModel
import com.example.android.devbyteviewer.domain.DevByteVideo
import com.example.android.devbyteviewer.network.DevByteNetwork
import com.example.android.devbyteviewer.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

// Add Repository to the project

//create VideosRepositoryclass. Pass VideosDatabaseobject as class constructor parameter to access Daomethod.
class VideosRepository(private val database: VideosDatabase){


//    add suspend  refreshVideos() a method that has no arguments and returns nothing. This method will be the API used to refresh the offline cache.
    suspend fun refreshVideos(){
//        switch the coroutine context to Dispatchers.IOto perform network and database operations.
        withContext(Dispatchers.IO){
//            add Timber
            Timber.d("refresh videos is called");
//            retrieve a DevByte video playlist from the network using the Retrofit service instance, DevByteNetwork.
            val playList = DevByteNetwork.devbytes.getPlaylist()
//            save playList to the database
            database.videoDao.insertAll(playList.asDatabaseModel())
        }
    }

//    declare a LiveData object called videos hold a list of DevByteVideo objects.
//    use Transformations.map to convert database object data to a list of domain objects
    val videos : LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()){
//    asDomainModel() method converts the database object to a domain object
        it.asDomainModel()
    }
}

