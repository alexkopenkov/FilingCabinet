package com.example.filingcabinet.data.repository

import com.example.filingcabinet.data.locale.EmployeesDao
import com.example.filingcabinet.data.locale.entity.EmployeeLocaleEntity
import com.example.filingcabinet.data.locale.entity.SpecialtyLocaleEntity
import com.example.filingcabinet.data.mapper.mapToLocaleEntities
import com.example.filingcabinet.data.mapper.mapToModel
import com.example.filingcabinet.data.remote.EmployeesRemoteDataSource
import com.example.filingcabinet.domain.model.EmployeeModel
import com.example.filingcabinet.domain.model.SpecialtyModel
import com.example.filingcabinet.domain.repository.FillingCabinetRepository
import com.example.filingcabinet.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
class FillingCabinetRepositoryImpl(
    private val remoteDataSource: EmployeesRemoteDataSource,
    private val localDataSource: EmployeesDao
) : FillingCabinetRepository {

    override fun getSpecialties(): Flow<Result<List<SpecialtyModel>>> = flow {

        val source = localDataSource.getAllSpecialties()
            .map {
                Result.Success(
                    it.map { entity -> entity.mapToModel() }
                )
            }
        // Emit Database content first
        emit(source.first())

        // Emit Loading State
        emit(Result.Loading)

        // Fetch latest data from remote
        when (val response = remoteDataSource.getEmployees()) {
            is Result.Success -> {
                val specialties = emptyList<SpecialtyLocaleEntity>().toMutableList()
                val employees = emptyList<EmployeeLocaleEntity>().toMutableList()

                response.data.employees.onEach { remoteEntity ->
                    val pair = remoteEntity.mapToLocaleEntities()
                    pair.first?.let { specialty ->
                        specialties.add(specialty)
                        pair.second?.let { employee -> employees.add(employee) }
                    }
                }
                // Save data into the persistence storage
                localDataSource.insertAll(specialties, employees)
            }
            is Result.Error -> emit(Result.Error(response.message))
            else -> {}
        }

        emitAll(source)

    }.flowOn(Dispatchers.IO)
        .catch { emit(Result.Error("Getting data error!")) }

    override suspend fun getEmployees(specialtyId: Int): List<EmployeeModel> =
        localDataSource.getEmployeesBySpecialtyId(specialtyId).map { it.mapToModel() }

}