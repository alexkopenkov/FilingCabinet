package com.example.filingcabinet.utils

import java.util.*

fun String.toTrimAndCapitalize(locale: Locale): String {
    val trimString = this.trim()
    if (trimString.isNotEmpty()) {
        return buildString {
            val firstChar = trimString[0]
            if (firstChar.isLowerCase()) {
                val titleChar = firstChar.toTitleCase()
                if (titleChar != firstChar.toUpperCase()) {
                    append(titleChar)
                } else {
                    append(trimString.substring(0, 1).toUpperCase(locale))
                }
            } else {
                append(trimString.substring(0, 1))
            }
            append(trimString.substring(1).toLowerCase(locale))
        }
    }
    return trimString
}