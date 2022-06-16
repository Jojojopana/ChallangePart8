package com.binar.challange8

import android.app.Application
import com.binar.challange8.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModul,
                    photosDataSourceModule,
                    repositoryModule,
                    viewModelModule,
                    localModule,
                    favoriteDataSource
                )
            )
        }
    }
}