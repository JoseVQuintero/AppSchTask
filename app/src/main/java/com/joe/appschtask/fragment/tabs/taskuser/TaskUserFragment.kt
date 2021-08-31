package com.joe.appschtask.fragment.tabs.taskuser

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.joe.appschtask.R
import com.joe.appschtask.domain.Task
import kotlinx.android.synthetic.main.fragment_task_user.*
import java.time.LocalDateTime
import java.util.*

class TaskUserFragment: Fragment(), View.OnClickListener, TaskUserInteractor.View {
    private var user: FirebaseUser?= null
    private var auth: FirebaseAuth?=null
    private val task = Task()
    private var presenter: TaskUserPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_task_user, container, false)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TaskUserPresenter(requireContext(), this)
        auth = FirebaseAuth.getInstance()
        btnAddTask.setOnClickListener {

            val taskId = UUID.randomUUID().toString()
            val dateStart = LocalDateTime.now().toString()
            val dateFinish= LocalDateTime.now().toString()
            val description= edtDescription.text.toString()
            val name = edtDescription.text.toString()
            val userId = auth!!.currentUser!!.uid
            val currentStatus = "New"
            val company = "Prueba"

            presenter!!.createUserTask(
                Task(
                    taskId = taskId,
                    dateStart = dateStart,
                    dateFinish= dateFinish,
                    description= description,
                    name = name,
                    userId = userId,
                    currentStatus = currentStatus,
                    company = company,
                )
            )
        }
    }

    override fun onClick(v: View?) {

    }

    override fun showError(msg: String) {
        Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
    }

    override fun taskCreate(msg: String) {
        Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
    }
}