package com.example.filingcabinet.data.locale

import androidx.room.*
import com.example.filingcabinet.data.locale.entity.EmployeeLocaleEntity
import com.example.filingcabinet.data.locale.entity.SpecialtyLocaleEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class EmployeesDao {

    @Transaction
    open suspend fun insertAll(
        specialties: List<SpecialtyLocaleEntity>,
        employees: List<EmployeeLocaleEntity>
    ) {
        _clearSpecialties()
        _clearEmployees()
        _insertSpecialties(specialties)
        _insertEmployees(employees)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun _insertEmployees(employees: List<EmployeeLocaleEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun _insertSpecialties(specialties: List<SpecialtyLocaleEntity>): List<Long>

    @Query("DELETE FROM specialties")
    abstract suspend fun _clearSpecialties()

    @Query("DELETE FROM employees")
    abstract suspend fun _clearEmployees()

    @Query("SELECT * FROM specialties")
    abstract fun getAllSpecialties(): Flow<List<SpecialtyLocaleEntity>>

    @Query("SELECT * FROM employees WHERE specialty_id = :specialtyId")
    abstract suspend fun getEmployeesBySpecialtyId(specialtyId: Int): List<EmployeeLocaleEntity>

}