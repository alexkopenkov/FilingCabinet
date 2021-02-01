package com.example.filingcabinet

import android.app.Application
import com.example.filingcabinet.data.dataModule
import com.example.filingcabinet.data.locale.dbModule
import com.example.filingcabinet.data.remote.remoteModule
import com.example.filingcabinet.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FCApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FCApplication)
            modules(
                listOf(
                    dbModule,
                    remoteModule,
                    dataModule,
                    uiModule
                )
            )
        }
    }

}