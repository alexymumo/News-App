package com.alexmumo.presentation.state

import androidx.paging.PagingData
import com.alexmumo.domain.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SearchState(
    val articles: Flow<PagingData<Article>> = emptyFlow(),
    val errors: String? = null,
    val isLoading: Boolean = true
)