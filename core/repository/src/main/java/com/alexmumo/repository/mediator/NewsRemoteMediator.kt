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
package com.alexmumo.repository.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.alexmumo.common.Constants.NEWS_API_KEY
import com.alexmumo.database.db.NewsDatabase
import com.alexmumo.database.entity.RemoteKeyEntity
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.mappers.toEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    private val category: String,
    private val newsDatabase: NewsDatabase,
    private val newsApi: NewsApi
) : RemoteMediator<Int, Article>() {

    //val articleDao = newsDatabase.articleDao()
    //val remoteKeyDao = newsDatabase.remoteKeyDao()

    /*
    *updating the backing database and invalidating PagingSource
    * */
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Article>
    ): MediatorResult {
        try {
            val response = newsApi.getTopHeadLines(
                country = "us",
                category = category,
                pageSize = 30,
                page = 1,
                apiKey = NEWS_API_KEY
            )
            val newsResponse = response.body()?.articles ?: listOf()
            val endOfPagination = newsResponse.isNullOrEmpty()

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosesToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: 1
                }
                LoadType.APPEND -> {
                    val remoteKeys = getLastRemoteKey(state)
                    val nextKey = remoteKeys?.nextKey
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                    nextKey
                }
                LoadType.PREPEND -> {
                    val remoteKey = getFirstRemoteKey(state)
                    val prevKey = remoteKey?.prevKey
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)
                    prevKey
                }
            }

            if (newsResponse != null) {
                newsDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        newsDatabase.remoteKeyDao().deleteRemoteKey()
                        newsDatabase.articleDao().deleteArticles()
                    }
                    val prevKey = if (page == 1) null else page - 1
                    val nextKey = if (endOfPagination) null else page - 1
                    val remoteKeys = newsResponse.map {
                        RemoteKeyEntity(it.url, nextKey, prevKey)
                    }
                    newsDatabase.remoteKeyDao().saveRemoteKey(remoteKeys)
                    newsDatabase.articleDao().saveArticles(newsResponse.map { it.toEntity() })
                }
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPagination)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, Article>): RemoteKeyEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull() ?.let { article ->
            newsDatabase.remoteKeyDao().getRemoteKeys(article.url)
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, Article>): RemoteKeyEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { article ->
            newsDatabase.remoteKeyDao().getRemoteKeys(article.url)
        }
    }

    private suspend fun getRemoteKeyClosesToCurrentPosition(state: PagingState<Int, Article>): RemoteKeyEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.url?.let { url ->
                newsDatabase.remoteKeyDao().getRemoteKeys(url)
            }
        }
    }

    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }
}
