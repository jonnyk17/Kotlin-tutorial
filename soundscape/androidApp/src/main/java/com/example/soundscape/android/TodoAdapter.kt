package com.example.soundscape.android

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class TodoAdapter (
    private val todo: MutableList<Todo>

): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemtodo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todo[position]

    }

    override fun getItemCount(): Int {
        return todo.size
    }
}