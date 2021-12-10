package com.airvet.demo

import android.app.Application
import com.airvet.demo.di.repositoryModule
import com.airvet.demo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin() {
            // declare used Android context
            androidContext(this@App)
            // declare modules
            modules(
                listOf(viewModelModule, repositoryModule)
            )
        }
    }
}