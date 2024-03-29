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
package com.alexmumo.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexmumo.common.Constants.NEWS_API_KEY
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.mappers.toDomain
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_NEWS_PAGE = 1
class NewsPagingSource(private val category: String, private val newsApi: NewsApi) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: STARTING_NEWS_PAGE
        return try {
            val response = newsApi.getTopHeadLines(
                country = "us",
                category = category,
                pageSize = 30,
                page = 1,
                apiKey = NEWS_API_KEY
            )
            val newsResponse = response.body()?.articles ?: listOf()
            val nextKey = if (newsResponse.isEmpty()) {
                null
            } else {
                page + 1
            }
            LoadResult.Page(
                data = newsResponse.map { it.toDomain() },
                prevKey = if (page == STARTING_NEWS_PAGE) null else page,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }
}
