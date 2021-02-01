package com.example.filingcabinet.data.mapper

import com.example.filingcabinet.data.locale.entity.EmployeeLocaleEntity
import com.example.filingcabinet.data.locale.entity.SpecialtyLocaleEntity
import com.example.filingcabinet.data.remote.entity.EmployeeRemoteEntity
import com.example.filingcabinet.domain.model.EmployeeModel
import com.example.filingcabinet.domain.model.SpecialtyModel
import com.example.filingcabinet.utils.dateToDatestamp
import com.example.filingcabinet.utils.toTrimAndCapitalize
import java.util.*

fun SpecialtyLocaleEntity.mapToModel() = SpecialtyModel(
    id = this.id,
    name = this.name
)

fun EmployeeLocaleEntity.mapToModel() = EmployeeModel(
    firstName = this.firstName,
    lastName = this.lastName,
    birthday = this.birthday,
    avatar = this.avatar
)

fun EmployeeRemoteEntity.mapToLocaleEntities(): Pair<SpecialtyLocaleEntity?, EmployeeLocaleEntity?> =
    if (this.firstName == null || this.lastName == null || this.specialty[0].name == null) {
        Pair(null, null)
    } else Pair(
        first = SpecialtyLocaleEntity(
            id = this.specialty[0].id,
            name = this.specialty[0].name!!.capitalize(Locale.getDefault())
        ),
        second = EmployeeLocaleEntity(
            firstName = this.firstName.toTrimAndCapitalize(Locale.getDefault()),
            lastName = this.lastName.toTrimAndCapitalize(Locale.getDefault()),
            birthday = dateToDatestamp(this.birthday),
            avatar = this.avatar,
            specialtyId = this.specialty[0].id
        )
    )