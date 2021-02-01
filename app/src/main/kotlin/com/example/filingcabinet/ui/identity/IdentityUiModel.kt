package com.example.filingcabinet.ui.identity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IdentityUiModel(
    val fullName: String,
    val birthday: String,
    val age: Int,
    val avatar: String?,
    val specialty: String
) : Parcelable

