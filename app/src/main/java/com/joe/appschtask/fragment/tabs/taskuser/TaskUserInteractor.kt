package com.joe.appschtask.fragment.tabs.taskuser

import com.joe.appschtask.domain.Task

interface TaskUserInteractor {

    interface Presenter{
        fun createUserTask(task:Task)
    }

    interface View {
        fun showError(msg: String)
        fun onSuccess(msg: String)
        fun taskCreate(msg: String)
    }
}