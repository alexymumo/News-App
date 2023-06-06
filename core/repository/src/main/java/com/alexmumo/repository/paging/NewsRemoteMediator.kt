package com.alexmumo.repository.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi

@ExperimentalPagingApi
class NewsRemoteMediator(
    private val category: String,
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
): RemoteMediator<Int, Article>() {

    /*
    * @params PagingState - info about pages loaded so far
    * @params LoadType - indicate type of load
    * */
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Article>
    ): MediatorResult {
        TODO("Not yet implemented")
        val loadKey = when(loadType) {
            LoadType.REFRESH -> null
            LoadType.PREPEND -> null
            LoadType.APPEND -> null
        }
    }

}