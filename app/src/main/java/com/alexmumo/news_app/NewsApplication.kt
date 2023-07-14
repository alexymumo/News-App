package com.alexmumo.news_app

import android.app.Application
import com.alexmumo.database.di.databaseModule
import com.alexmumo.network.di.networkModule
import com.alexmumo.presentation.di.presentationModule
import com.alexmumo.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@NewsApplication)
            modules(repositoryModule, networkModule, presentationModule, databaseModule)
            initTimber()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }
}
