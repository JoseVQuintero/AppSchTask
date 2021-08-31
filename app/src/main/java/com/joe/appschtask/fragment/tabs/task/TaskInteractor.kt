package com.joe.appschtask.fragment.tabs.task


import com.joe.appschtask.domain.Task

interface TaskInteractor {
    interface Presenter{
        fun getTask()
    }

    interface View {
        fun onSuccess()
        fun setTasks(tasks: List<Task>)

    }
}