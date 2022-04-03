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

package com.example.android.marsrealestate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

//create enum class for filtering the data
enum class MarsApiFilter(val value: String){
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}


//create a Moshi instance.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()

// use Retrofit builder to create Retrofit objects
private val retrofit = retrofit2.Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()


//define an interface that defines how Retrofit talks to the web server using HTTP requests.
interface  MarsApiService{
    @GET("realestate")
//    a method to take a string input for a filter query, and annotate that input with @Query("filter")
    suspend fun getProperties(@Query("filter") type: String): List<MarsProperty>
}

//define a public object called MarsApito initialize the Retrofit service to make service object
object MarsApi{
    val retrofitService : MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}