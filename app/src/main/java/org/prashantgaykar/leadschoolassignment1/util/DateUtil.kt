package org.prashantgaykar.leadschoolassignment1.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private val timeFormat: SimpleDateFormat = SimpleDateFormat("hh:mm a", Locale("en"))

    fun convertTo12HourTimeString(date: Date): String = timeFormat.format(date)
}