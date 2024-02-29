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

import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : SearchRepository {
    override suspend fun searchNews(queryString: String): Flow<List<Article>> {
        return flow {
            emit(newsApi.searchNews(queryString))
        }.map { response ->
            val searchResponse = response.body()?.articles ?: listOf()
            searchResponse.map { it.toDomain() }
        }
    }
}
