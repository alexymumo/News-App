package com.alexmumo.repository.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.alexmumo.domain.model.Article
import com.alexmumo.network.api.NewsApi

@ExperimentalPagingApi
class NewsRemoteMediator(
    private val newsApi: NewsApi,
    private val category: String
): RemoteMediator<Int, Article>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Article>
    ): MediatorResult {
        TODO("Not yet implemented")
    }

}