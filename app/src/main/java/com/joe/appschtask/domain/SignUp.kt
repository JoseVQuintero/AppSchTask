package com.joe.appschtask.domain

data class SignUp(
    var userId: String = "",
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val lastName: String = "",
    val repeatPassword: String = ""
)