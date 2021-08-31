package com.joe.appschtask.domain

import java.io.Serializable
import java.time.LocalDateTime

data class Task(
    var taskId: String = "",
    var dateStart: String = "",
    var dateFinish: String = "",
    var description: String = "",
    var name: String = "",
    var userId: String = "",
    var currentStatus: String = "",
    var company: String = ""
): Serializable
