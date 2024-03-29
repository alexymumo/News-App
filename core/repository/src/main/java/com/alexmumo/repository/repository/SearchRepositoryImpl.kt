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

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : SearchRepository {
    override suspend fun searchNews(queryString: String): Flow<PagingData<Article>> {
        val pagingConfig = PagingConfig(
            pageSize = 30,
            enablePlaceholders = true
        )
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                SearchPagingSource(newsApi = newsApi, queryString = queryString)
            }
        ).flow
    }
}
