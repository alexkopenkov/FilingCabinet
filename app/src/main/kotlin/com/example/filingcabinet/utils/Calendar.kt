package com.example.filingcabinet.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun dateToDatestamp(date: String?): Long? =
    if (date.isNullOrBlank()) null
    else {
        val parser: SimpleDateFormat =
            if (date[2].compareTo('-') == 0 && date[5].compareTo('-') == 0)
                SimpleDateFormat("dd-MM-yyyy", Locale.forLanguageTag("RU"))
            else
                SimpleDateFormat("yyyy-MM-dd", Locale.forLanguageTag("RU"))
        try {
            val formattedDate = parser.parse(date)
            formattedDate?.time
        } catch (e: ParseException) {
            null
        }
}

fun datestampToDate(datestamp: Long?): String =
    if (datestamp == null) ""
    else {
        val df = SimpleDateFormat("dd.MM.yyyy", Locale.forLanguageTag("RU"))
        val currentDate = Date(datestamp)
        df.format(currentDate)
    }

fun getAge(milliseconds: Long): Int {

    val dob= Calendar.getInstance()
    val today= Calendar.getInstance()

    dob.time = Date(milliseconds)

    val year= dob.get(Calendar.YEAR)
    val month= dob.get(Calendar.MONTH)
    val day= dob.get(Calendar.DAY_OF_MONTH)
    dob.set(year, month + 1, day)
    var age= today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
        age--
    }
    return age
}
