package com.joe.appschtask.presentation.container

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

class ContainerPresenter (
    private val context: Context,
    private val view: ContainerContract.View
): ContainerContract.Presenter {

    private val auth = FirebaseAuth.getInstance()

    override fun logoutUser() {
        auth.signOut()
    }
}