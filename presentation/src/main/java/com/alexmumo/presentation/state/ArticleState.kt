package com.alexmumo.presentation.state

import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class ArticleState(
    val articles: Flow<PagingData<Article>>? = null,
    val errors: String? = null,
    val isLoading: Boolean = true
)
