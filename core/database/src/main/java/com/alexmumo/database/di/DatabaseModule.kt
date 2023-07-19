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
package com.alexmumo.database.di

import androidx.room.Room
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.dao.RemoteKeyDao
import com.alexmumo.database.db.NewsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NewsDatabase::class.java,
            "article.db"
        ).fallbackToDestructiveMigration().build()
    }

    single<BookMarkDao> {
        val db = get<NewsDatabase>()
        db.bookMarkDao()
    }

    single<ArticleDao> {
        val database = get<NewsDatabase>()
        database.articleDao()
    }

    single<RemoteKeyDao> {
        val db = get<NewsDatabase>()
        db.remoteKeyDao()
    }
}
