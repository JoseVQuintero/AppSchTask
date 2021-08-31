package com.joe.appschtask.presentation.form.users

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.joe.appschtask.R
import com.joe.appschtask.presentation.domain.SignUp
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity: AppCompatActivity(), UserContract.View {
    private var user: FirebaseUser?= null
    private var auth: FirebaseAuth?=null
    private var presenter: UserPresenter? = null
    private val signUp = SignUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        auth = FirebaseAuth.getInstance()
        user = auth!!.currentUser
        presenter = UserPresenter(this, this)

        setupActions()

        btnAddUser.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val lastName = edtLastName.text.toString()
            val password = edtPassword.text.toString()
            val repeatPassword = edtRepeatPassword.text.toString()

            presenter!!.createUser(
                SignUp(
                    name = name,
                    email = email,
                    lastName = lastName,
                    password = password,
                    repeatPassword = repeatPassword
                )
            )
        }

    }
    override fun onSuccess(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
    override fun showError(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setupActions() {
        imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun userCreate(msg: String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
        onBackPressed()
    }
}