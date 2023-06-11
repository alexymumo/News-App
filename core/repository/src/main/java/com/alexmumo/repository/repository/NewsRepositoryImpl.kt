package com.alexmumo.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.paging.NewsPagingSource
import com.alexmumo.repository.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl constructor(private val newsApi: NewsApi): NewsRepository {
    override suspend fun fetchNews(category: String): Flow<PagingData<Article>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        )
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                NewsPagingSource(category = category, newsApi = newsApi)
            }
        ).flow
    }

    override suspend fun searchNews(queryString: String): Flow<PagingData<Article>> {
        val pagingConfig = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        )
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                SearchPagingSource(newsApi = newsApi, searchString = queryString)
            }
        ).flow
    }
}