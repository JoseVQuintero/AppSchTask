package com.joe.appschtask.domain
data class DateTime (
    var chronology: Chronology,
    var dayOfMonth: Number,
    var dayOfWeek: String,
    var dayOfYear: Number,
    var year: Int,
    var day: Int,
    var hour: Int,
    var minute: Int,
    var second: Int,
    var millisecond: Number,
    var nano: Number,
    var month: String,
    var monthValue: Number
)
