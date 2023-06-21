package com.alexmumo.presentation.state

import com.alexmumo.domain.model.Article

data class ArticleState(
    val articles: List<Article> = emptyList(),
    val errors: String? = null,
    val isLoading: Boolean = false
)
