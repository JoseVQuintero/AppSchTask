package com.joe.appschtask.presentation.domain

import java.io.Serializable

data class SignUp(
    var userId: String="",
    var email: String="",
    var password: String="",
    var repeatPassword: String="",
    var name: String="",
    var lastName: String=""
): Serializable