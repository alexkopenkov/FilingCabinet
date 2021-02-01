package com.example.filingcabinet.data.remote

import com.example.filingcabinet.data.remote.entity.EmployeesRemoteEntity
import retrofit2.Response
import retrofit2.http.GET

interface EmployeesApi {

    @GET("65gb/static/raw/master/testTask.json")
    suspend fun getEmployees(): Response<EmployeesRemoteEntity>

}