package com.alexmumo.news_app

import android.app.Application
import com.alexmumo.network.di.networkModule
import com.alexmumo.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@NewsApplication)
            modules(repositoryModule, networkModule)
        }
    }
}