package com.joe.appschtask.presentation.form.users


import com.joe.appschtask.presentation.domain.SignUp

interface UserContract {
    interface Presenter {
        fun validateEmail(email: String): Boolean
        fun createUser(signUp: SignUp)
    }

    interface View {
        fun showError(msg: String)
        fun onSuccess(msg: String)
        fun userCreate(msg: String)
    }
}