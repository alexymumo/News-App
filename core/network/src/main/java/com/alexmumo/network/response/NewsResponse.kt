package com.alexmumo.network.response

import com.alexmumo.network.dto.ArticleDto

data class NewsResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)