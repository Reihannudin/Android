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

package com.example.android.marsrealestate

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.MarsApiStatus
import com.example.android.marsrealestate.overview.PhotoGridAdapter


//The @BindingAdapter annotation tells the databinding that you want this binding adapter to run when the XML item has the imageUr attribute
@BindingAdapter("imageUrl")
//make function bindImage
fun bindImage(imgView: ImageView, imgUrl:String?){
//    add let to imgUrl to check if it is not null
    imgUrl?.let {
//    convert imgUrl to Uri
        val imgUri = it.toUri().buildUpon().scheme("https").build()
//        call gilde
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}


//The @BindingAdapter annotation tells the databinding that you want this binding adapter to run when the XML item has the imageUr attribute
@BindingAdapter("listData")
//make funtcion bindRecyclerView
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>?){
//    cast recyclerView.adapter to PhotoGridAdapter
    val adapter = recyclerView.adapter as PhotoGridAdapter
//    call adapter.submitList to update the data
    adapter.submitList(data)
}

//The @BindingAdapter annotation tells the databinding that you want this binding adapter to run when the XML item has the imageUr attribute
@BindingAdapter("marsApiStatus")
//make fun bindStatus
fun bindStatus(statusImageView: ImageView, status : MarsApiStatus?){
//    add when to check the status
    when(status){
//        when status is loading
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation) // set the image to loading
        }
//        when status is error
        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error) // set the image to error
        }
//        when status is DONE
        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}