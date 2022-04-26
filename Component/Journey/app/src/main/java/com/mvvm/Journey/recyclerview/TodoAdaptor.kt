package com.mvvm.Journey.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.Journey.R

class TodoAdaptor (var todos: List<Todo>)
    : RecyclerView.Adapter<TodoAdaptor.TodoViewHolder>(){

//    make inner class
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent ,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tv_title)
            val cbDone = findViewById<CheckBox>(R.id.cb_done)

            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}