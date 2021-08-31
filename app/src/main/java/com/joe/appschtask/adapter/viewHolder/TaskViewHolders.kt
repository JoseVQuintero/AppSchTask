package com.joe.appschtask.adapter.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joe.appschtask.R

class TaskViewHolders(private val view: View): RecyclerView.ViewHolder(view) {
    val tvTitle = view.findViewById(R.id.tvTitle) as TextView
    val imgTask = view.findViewById(R.id.imgTask) as ImageView
    val tvDescription = view.findViewById(R.id.tvDescription) as TextView
}