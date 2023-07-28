/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alexmumo.news_app

import android.app.Application
import com.alexmumo.database.di.databaseModule
import com.alexmumo.datastore.datastoreModule
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
            modules(repositoryModule, networkModule, presentationModule, databaseModule, datastoreModule)
            initTimber()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }
}
