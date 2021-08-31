package com.joe.appschtask.fragment.tabs.task

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.joe.appschtask.domain.Task

class TaskPresenter(
        private val context: Context,
        private val view: TaskInteractor.View):TaskInteractor.Presenter {
    private val cloud = FirebaseFirestore.getInstance()
    private val tasks = arrayListOf<Task>()
    override fun getTask() {
        cloud.collection("tasks")
            .get()
            .addOnCompleteListener(OnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val doc = document.toObject(Task::class.java)
                        Log.d("TAG", document.id + " => " + document.data)
                        tasks!!.add(
                            Task(
                            taskId = doc.taskId,
                            dateStart = doc.dateStart,
                            dateFinish= doc.dateFinish,
                            description= doc.description,
                            name = doc.name,
                            userId = doc.userId,
                            currentStatus = doc.currentStatus,
                            company = doc.company
                        )
                        )
                    }
                    view.setTasks(tasks!!)
                } else {
                    Log.d("TAG", "Error getting documents: ", task.exception)
                }
            })
    }
}