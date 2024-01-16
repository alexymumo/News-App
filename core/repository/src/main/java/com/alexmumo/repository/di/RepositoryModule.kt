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
package com.alexmumo.repository.di

import com.alexmumo.database.db.NewsDatabase
import com.alexmumo.domain.repository.BookMarkRepository
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.repository.BookMarkRepositoryImpl
import com.alexmumo.repository.repository.NewsRepositoryImpl
import com.alexmumo.repository.repository.SearchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesNewsRepository(newsDatabase: NewsDatabase, newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsDatabase, newsApi)
    }

    @Provides
    @Singleton
    fun providesSearchRepository(newsApi: NewsApi): SearchRepository {
        return SearchRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun providesBookMarkRepository(newsDatabase: NewsDatabase): BookMarkRepository {
        return BookMarkRepositoryImpl(newsDatabase.bookMarkDao())
    }
}
