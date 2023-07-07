package com.alexmumo.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.SearchRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val newsApi: NewsApi): SearchRepository {
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