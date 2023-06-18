package com.alexmumo.news_app

import android.app.Application
import timber.log.Timber

class NewsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }
}