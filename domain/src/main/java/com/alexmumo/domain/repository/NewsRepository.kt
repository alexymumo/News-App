package com.alexmumo.domain.repository

import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun fetchNews(category: String): Flow<PagingData<Article>>
    suspend fun searchNews(queryString: String): Flow<PagingData<Article>>
}