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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.MarsProperty

// make PhotoGridAdapter class and Extend ListAdapter and diffUtils
class PhotoGridAdapter(private val onClickListener: OnClickListener ) : ListAdapter<MarsProperty,
        PhotoGridAdapter. MarsPropertyViewHolder>(DiffCallback) {
//  implement ListAdapter Methode
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MarsPropertyViewHolder {
    // return MarsPropertyViewHolder and created by inflating the GridViewItemBinding and using the LayoutInflater from your parent ViewGroup context.
        return MarsPropertyViewHolder(GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)))
    }
//  implement ListAdapter Methode
    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
//    Here you call getItem() to get the MarsProperty object associated with the current RecyclerView position, and then pass that property to the bind() method in the MarsPropertyViewHolder
      val marsProperty = getItem(position)
//    Make photos clickable by adding onClickListener items to the grid
      holder.itemView.setOnClickListener {
          onClickListener.onClick(marsProperty)
      }
          holder.bind(marsProperty)
    }

    //     define class DiffCallback with companion object and extend DiffUtil.ItemCallback with object MarsProperty
    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
//        apply comparison method to object
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//        Use the referential equality operator ( ===), which returns true if object references are equal   apply comparison method to object
            return oldItem === newItem
        }
//        apply comparison method to object
        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//        use the standard structural equation operator only on the IDs of oldItem and newItem.
            return oldItem.id == newItem.id
        }
    }
//    define class MarsPropertyViewHolder extend RecyclerView and requires a GridViewItemBinding variable to bind to MarsProperty
    class MarsPropertyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
//    make function bind get marsProperty as object argument
        fun bind(marsProperty: MarsProperty) {
//    get marsProperty and set bindin.property
            binding.property = marsProperty
//    call executePendingBindings to update the UI
            binding.executePendingBindings()
        }
    }

//    create a custom OnClickListener class that takes a lambda with marsPropertyparameter
    class OnClickListener(val clickListener: (marsProperty: MarsProperty) -> Unit) {
//    define function onClick with marsProperty as object argument
        fun onClick(marsProperty:MarsProperty) = clickListener(marsProperty)
    }
}