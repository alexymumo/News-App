package com.alexmumo.repository.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.repository.NewsRepository
import com.alexmumo.network.api.NewsApi
import com.alexmumo.repository.paging.NewsRemoteMediator
import kotlinx.coroutines.flow.Flow


class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
): NewsRepository {
    override suspend fun fetchNews(category: String): Flow<PagingData<Article>> {

        TODO()
        //val pagingSource = articleDao.getPagingArticles(category)


        /*
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true
            ),
            remoteMediator = NewsRemoteMediator(
                category = category,
                newsApi = newsApi,
                articleDao = articleDao
            ),
            pagingSourceFactory = pagingSource
        )*/
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun searchNews(queryString: String): Flow<PagingData<Article>> {
        TODO()
    }
}