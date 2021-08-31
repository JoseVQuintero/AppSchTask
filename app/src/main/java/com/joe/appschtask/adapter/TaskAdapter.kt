package com.joe.appschtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joe.appschtask.R
import com.joe.appschtask.domain.Task
import com.joe.appschtask.adapter.listener.ListenerTask
import com.joe.appschtask.adapter.viewHolder.TaskViewHolders

class TaskAdapter(
    private val context: Context,
    private var task: List<Task>,
    private val listener: ListenerTask
): RecyclerView.Adapter<TaskViewHolders>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolders {
        return TaskViewHolders(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_task, parent, false)
        )
    }

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: TaskViewHolders, position: Int) {
        val task = task[position]
        holder.tvTitle.text = task.name
        holder.tvDescription.text = task.description
        holder.itemView.setOnClickListener {
            //Log.e("","${note.description}")
            //listener.onClickNote(beer)
        }
    }

    fun updateData(tasks: List<Task>){
        this.task = tasks
        notifyDataSetChanged()
    }
}