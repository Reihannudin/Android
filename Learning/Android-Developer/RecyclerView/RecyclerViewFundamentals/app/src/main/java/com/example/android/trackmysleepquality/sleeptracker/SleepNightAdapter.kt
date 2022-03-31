package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

//Make Adapter for SleepNight
// amke class SleepNightAdapter extend RecyclerView.Adapter
//Langkah 3: Gunakan ViewHolder di SleepNightAdapter
class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {
    //    make variable data for saving data from SleepNight
    var data = listOf<SleepNight>()
//    The adapter needs to let the RecyclerView know when data has changed,

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //    override fun getItemCount from size of data
    override fun getItemCount(): Int = data.size

    //    the function needs to know the type of display that will be used.
    //    This function takes two parameters and returns a ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        make instance
//        In the adapter for the recycler view, you always pass in the context of the view's parentgroup, the RecyclerView.
        val layoutInflater = LayoutInflater.from(parent.context)
//        create a view by asking layout inflater to expand it
        val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)
//    return the viewholder
        return ViewHolder.from(parent)
    }

    //    The onBindViewHolder function is called to display data for a single list item at the specified position.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    //Create a class inside that SleepNightAdapter called ViewHolder and make it extend RecyclerView.ViewHolder.
    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*
        * Inside the ViewHolder, get a reference to the view. You need a reference to this view that the ViewHolder will update.
        * Whenever you bind this ViewHolder, you need to access the image and both text views. (You convert this code to use data
        * binding later.)
        * */
        val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
        val quality: TextView = itemView.findViewById(R.id.quality_string)
        val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

        fun bind(item: SleepNight) {
            val res = itemView.context.resources
            sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
            quality.text = convertNumericQualityToString(item.sleepQuality, res)
            qualityImage.setImageResource(when (item.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_sleep_night, parent, false)
                return ViewHolder(view)
            }
        }

    }
}
