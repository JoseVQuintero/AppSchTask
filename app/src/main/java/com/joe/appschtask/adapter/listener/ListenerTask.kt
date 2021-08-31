package com.joe.appschtask.adapter.listener

import com.joe.appschtask.domain.Task


interface ListenerTask {
    fun onClickTask(task: Task)
}