package com.alexmumo.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    //val source: Source,
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String
)
