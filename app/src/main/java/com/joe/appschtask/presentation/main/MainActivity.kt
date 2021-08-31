package com.joe.appschtask.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.joe.appschtask.R
import com.joe.appschtask.presentation.container.ContainerActivity
import com.joe.appschtask.presentation.form.users.UserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private var auth: FirebaseAuth? = null
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        presenter = MainPresenter(this, this)
        setupActions()
    }

    override fun onStart() {
        super.onStart()
        if (auth?.currentUser != null) {
            //goToHome()
        }
    }

    override fun successLogin() {
        goToHome()
    }

    override fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun setupActions() {
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            presenter!!.goToLogin(email, password)
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, ContainerActivity::class.java))
        finish()
    }

}

