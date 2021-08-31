package com.joe.appschtask.domain

import java.io.Serializable
import java.time.LocalDateTime

data class TaskGet(
    var taskId: String = "",
    var dateStart: DateTime,
    var dateFinish: DateTime,
    var description: String = "",
    var name: String = "",
    var userId: String = "",
    var currentStatus: String = "",
    var company: String = ""
)