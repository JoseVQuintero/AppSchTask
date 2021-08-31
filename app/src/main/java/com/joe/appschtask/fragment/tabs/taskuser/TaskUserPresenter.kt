package com.joe.appschtask.fragment.tabs.taskuser

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.joe.appschtask.domain.Task
import java.util.*

class TaskUserPresenter (
    private val context: Context,
    private val view: TaskUserInteractor.View
): TaskUserInteractor.Presenter {

    private val cloud = FirebaseFirestore.getInstance()

    override fun createUserTask(task: Task) {
        task.taskId = UUID.randomUUID().toString()
        cloud.collection("tasks").document(task.taskId).set(task)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                view.taskCreate("Create task success")
            }
        }.addOnFailureListener {
            view.showError(it.message.toString())
        }
    }
}