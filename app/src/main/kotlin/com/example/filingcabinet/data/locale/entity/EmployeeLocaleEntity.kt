package com.example.filingcabinet.data.locale.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Table("employees") Example:
*  ———————————————————————————————————————————————————————————————————
* |  id   | first_name | last_name | birthday | avatar | specialty_id |
* | (int) |  (string)  |  (string) |  (long)  |(string)|     (int)    |
*  ———————————————————————————————————————————————————————————————————
* |  ...  |    ...     |    ...    |    ...   |   ...  |      ...     |
*  ———————————————————————————————————————————————————————————————————
*/
@Entity(tableName = "employees")
data class EmployeeLocaleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    val birthday: Long?,
    val avatar: String?,
    @ColumnInfo(name = "specialty_id") val specialtyId: Int
)