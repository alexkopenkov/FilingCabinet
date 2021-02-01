package com.example.filingcabinet.domain.model

import com.example.filingcabinet.utils.datestampToDate
import com.example.filingcabinet.utils.getAge

data class EmployeeModel(
    val firstName: String,
    val lastName: String,
    val birthday: Long?,
    val avatar: String?
) {

    val fullName = "$firstName $lastName".trim()

    val birthdayFormat = datestampToDate(birthday)

    val age = birthday?.let { getAge(it) } ?: 0

}