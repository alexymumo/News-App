package com.alexmumo.database.entity

import androidx.room.Entity

@Entity(tableName = "article_table")
data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    //val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)
