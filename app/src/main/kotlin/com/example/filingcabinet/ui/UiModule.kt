package com.example.filingcabinet.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { MainViewModel(repository = get()) }

}