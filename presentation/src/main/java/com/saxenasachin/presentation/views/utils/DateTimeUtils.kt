package com.saxenasachin.presentation.views.utils

import android.annotation.SuppressLint
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat

object DateTimeUtils {

    private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"

    @SuppressLint("SimpleDateFormat")
    fun getDayWithMonthName(input: String): String {
        val localDateTime = LocalDateTime.parse(input, DateTimeFormat.forPattern(DATE_FORMAT))
        return SimpleDateFormat("dd MMM''yy").format(localDateTime.toDate().time)
    }
}