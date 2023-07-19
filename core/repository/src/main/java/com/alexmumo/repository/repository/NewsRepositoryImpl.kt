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
package com.alexmumo.repository.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.database.db.NewsDatabase
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.mediator.NewsRemoteMediator
import com.alexmumo.repository.paging.NewsPagingSource
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl constructor(private val newsDatabase: NewsDatabase, private val newsApi: NewsApi) : NewsRepository {
    @OptIn(ExperimentalPagingApi::class)
    override suspend fun fetchNews(category: String): Flow<PagingData<Article>> {
        val pagingConfig = PagingConfig(
            pageSize = 30,
            enablePlaceholders = false
        )

        val remoteMediator = NewsRemoteMediator(
            category = category, newsDatabase = newsDatabase, newsApi = newsApi
        )
        return Pager(
            config = pagingConfig,
            remoteMediator = remoteMediator,
            pagingSourceFactory = {
                NewsPagingSource(category = category, newsApi = newsApi)
            }
        ).flow
    }
}
