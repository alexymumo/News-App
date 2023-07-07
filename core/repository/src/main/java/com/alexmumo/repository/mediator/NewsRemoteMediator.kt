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
import com.alexmumo.repository.mappers.toDomain
import com.alexmumo.repository.mappers.toEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    private val category: String,
    private val newsDatabase: NewsDatabase,
    private val newsApi: NewsApi): RemoteMediator<Int,Article>() {

    val articleDao = newsDatabase.articleDao()
    val remoteKeyDao = newsDatabase.remoteKeyDao()

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

            val page = when(loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosesToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: 1
                }
                LoadType.APPEND ->  {
                    val remoteKeys = getRemoteKeyLastItem(state)
                    val nextKey = remoteKeys?.nextKey
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                    nextKey
                }
                LoadType.PREPEND ->  {
                    val remoteKey = getRemoteKeyToLastItem(state)
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

    private fun getRemoteKeyToLastItem(state: PagingState<Int, Article>): RemoteKeyEntity? {
        TODO()
    }

    private fun getRemoteKeyLastItem(state: PagingState<Int, Article>): RemoteKeyEntity? {
        TODO()
    }

    private fun getRemoteKeyClosesToCurrentPosition(state: PagingState<Int, Article>): RemoteKeyEntity? {
        TODO()
    }

    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }
}