package com.joe.appschtask.presentation.container

import com.joe.appschtask.presentation.domain.SignUp

interface ContainerContract {
    interface Presenter {
        fun logoutUser()
    }

    interface View {

    }
}