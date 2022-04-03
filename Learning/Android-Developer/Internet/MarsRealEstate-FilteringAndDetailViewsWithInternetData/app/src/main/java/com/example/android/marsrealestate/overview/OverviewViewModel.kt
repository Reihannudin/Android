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
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsApiFilter
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//define enum class status for represent the status of the data
enum class MarsApiStatus { LOADING, ERROR, DONE }


/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the response String
    val status: LiveData<MarsApiStatus>
        get() = _status

//    add internal (mutable) and external (immutable) live data for a single MarsPropertyobject.
private val _properties = MutableLiveData<List<MarsProperty>>()

    val properties: LiveData<List<MarsProperty>>
        get() = _properties

//    make live data navigateToSelectedProperty
    private val _navigateToSelectedProperty = MutableLiveData<MarsProperty>()
    val navigateToSelectedProperty: LiveData<MarsProperty>
        get() = _navigateToSelectedProperty

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
//        With coroutines
        viewModelScope.launch {
//            add try an catch
            _status.value = MarsApiStatus.LOADING //show loading status
            try {
//            call getProperties objek retrofitService
                _properties.value = MarsApi.retrofitService.getProperties(filter.value)
                _status.value = MarsApiStatus.DONE // set value of status to done
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR // set value of status to error
                _properties.value = ArrayList() // set value of properties to empty list
            }
        }

    }
//    with callback
//        MarsApi.retrofitService.getProperties().enqueue(
//            object : Callback<List<MarsProperty>>{
//                override fun onResponse(call: Call<List<MarsProperty>>, response: Response<List<MarsProperty>>) {
//                    _response.value = "Success: ${response.body()?.size} Mars properties retrieved"
//                }
//
//                override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
//                    _response.value = "Test Success Failure: " + t.message
//                }
//
//            }
//        )
//    }


//    make fun updateFilter
    fun updateFilter(filter: MarsApiFilter) {
        getMarsRealEstateProperties(filter)
    }

//    add a displayPropertyDetails() method that sets navigateToSelectedProperty to the selected Mars property
    fun displayPropertyDetails(marsProperty: MarsProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

//    Add the displayPropertyDetailsComplete() method which negates the _navigateToSelectedProperty value. You need this to mark the navigation status as complete, and to avoid the navigation being triggered again when the user returns from the details view
    fun displayPropertyDetailsComplete(){
        _navigateToSelectedProperty.value = null
    }
}
