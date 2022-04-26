package com.mvvm.Journey.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.Journey.R

class TodoListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

     val todoList = mutableListOf(
         Todo("Buy milk", false),
         Todo("Buy eggs", false),
         Todo("Buy bread", false),
         Todo("Buy coffee", false),
         Todo("Buy tea", false),
         Todo("Buy milk", false)
     )

     val adapter = TodoAdaptor(todoList)

     val rv_Todos = findViewById<RecyclerView>(R.id.rvTodo)
        rv_Todos.adapter = adapter
        rv_Todos.layoutManager = LinearLayoutManager(this)

     val btn_add_todo = findViewById<Button>(R.id.btn_add_todo)
        btn_add_todo.setOnClickListener {
            val etTodo = findViewById<android.widget.EditText>(R.id.et_todo)
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}