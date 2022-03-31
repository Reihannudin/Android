package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import androidx.recyclerview.widget.ListAdapter
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

//Make Adapter for SleepNight
// make class SleepNightAdapter extend RecyclerView.Adapter
//Change your adapter to extend ListAdapter
class SleepNightAdapter : ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    //    the function needs to know the type of display that will be used.
    //    This function takes two parameters and returns a ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    //    The onBindViewHolder function is called to display data for a single list item at the specified position.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    //Create a class inside that SleepNightAdapter called ViewHolder and make it extend RecyclerView.ViewHolder.
    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SleepNight) {
            binding.sleep = item
            binding.executePendingBindings() //This call is an optimization that requests a data binding to execute all pending bindings immediately.
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

    }
}

//create a new top-level class SleepNightDiffCallback called extends DiffUtil.ItemCallback
class SleepNightDiffCallback: DiffUtil.ItemCallback<SleepNight>(){
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
//        oldItem and newItem, are the same. If the item has the same nightId
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
//        check if oldItem and newItem contain the same data
        return oldItem == newItem
    }
}


