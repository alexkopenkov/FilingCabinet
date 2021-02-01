package com.example.filingcabinet.domain.repository

import com.example.filingcabinet.domain.model.EmployeeModel
import com.example.filingcabinet.domain.model.SpecialtyModel
import com.example.filingcabinet.utils.Result
import kotlinx.coroutines.flow.Flow

interface FillingCabinetRepository {

    fun getSpecialties(): Flow<Result<List<SpecialtyModel>>>

    suspend fun getEmployees(specialtyId: Int): List<EmployeeModel>

}