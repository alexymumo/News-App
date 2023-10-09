package com.alexmumo.common

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun convertStringToDate(date: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val instant = Instant.parse(date)
    val zonedTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    return formatter.format(zonedTime)
}