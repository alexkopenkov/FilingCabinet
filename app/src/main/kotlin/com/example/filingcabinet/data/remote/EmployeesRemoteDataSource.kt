package com.example.filingcabinet.data.remote

class EmployeesRemoteDataSource(
    private val employeesApi: EmployeesApi
) : BaseDataSource() {

    suspend fun getEmployees() = getResult { employeesApi.getEmployees() }

}