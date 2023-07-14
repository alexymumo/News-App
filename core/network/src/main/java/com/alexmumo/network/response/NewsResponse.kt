package com.alexmumo.network.response

import androidx.annotation.Keep
import com.alexmumo.network.dto.ArticleDto

@Keep
data class NewsResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)
