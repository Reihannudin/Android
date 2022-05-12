package com.example.roomdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.databinding.ItemListBinding
import com.example.roomdemo.db.Subscriber

class MyRecyclerViewAdapter(private val subscriberList : List<Subscriber>,
                            private val clickListener: (Subscriber)-> Unit)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : ItemListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(subscriber : Subscriber, clickListener: (Subscriber)-> Unit){
            binding.tvItemName.text = subscriber.name
            binding.tvItemEmail.text = subscriber.email
            binding.listItemLayout.setOnClickListener {
                clickListener(subscriber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemListBinding = ItemListBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return subscriberList.size
    }
}