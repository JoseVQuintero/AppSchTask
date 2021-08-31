package com.joe.appschtask.presentation.main

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.joe.appschtask.R
import com.joe.appschtask.utils.Utils

class MainPresenter(private val context: Context, private val view: MainContract.View) :
    MainContract.Presenter {

    private var firebase = FirebaseAuth.getInstance()

    override fun goToLogin(email: String, password: String) {
        when {
            !Utils.isEmailValid(email) -> {
                view.showError(context.getString(R.string.error_email))

            }
            password.isEmpty() -> {
                view.showError(context.getString(R.string.error_password))

            }
            else -> {
                firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        view.successLogin()
                    } else {
                        view.showError(context.getString(R.string.error_try_again))
                    }
                }.addOnFailureListener {
                    view.showError(it.message.toString())
                }
            }
        }
    }
}