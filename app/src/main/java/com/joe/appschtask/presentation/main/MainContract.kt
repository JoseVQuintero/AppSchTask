package com.joe.appschtask.presentation.main
import com.joe.appschtask.base.BaseView

interface MainContract {

    interface Presenter {
        fun goToLogin(email: String, password: String)
    }

    interface View : BaseView {
        fun successLogin()
    }

}