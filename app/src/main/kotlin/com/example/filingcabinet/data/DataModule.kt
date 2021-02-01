package com.example.filingcabinet.data

import com.example.filingcabinet.data.repository.FillingCabinetRepositoryImpl
import com.example.filingcabinet.domain.repository.FillingCabinetRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val dataModule = module {

    single<FillingCabinetRepository> {
        FillingCabinetRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }

}