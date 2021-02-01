package com.example.filingcabinet.data.locale.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Table("specialties") Example:
*  ——————————————————
* |  id   |   name   |
* | (int) | (string) |
*  ——————————————————
* |  ...  |   ...    |
*  ——————————————————
*/
@Entity(tableName = "specialties")
data class SpecialtyLocaleEntity(
    @PrimaryKey val id: Int,
    val name: String
)