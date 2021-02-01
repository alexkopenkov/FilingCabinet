package com.example.filingcabinet.data.locale

import org.koin.dsl.module

val dbModule = module {

    single { AppDatabase.getDatabase(context = get()) }

    single { get<AppDatabase>().employeesDao() }

}