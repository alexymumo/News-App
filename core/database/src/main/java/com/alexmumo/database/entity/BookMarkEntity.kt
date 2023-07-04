package com.alexmumo.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark_table")
data class BookMarkEntity(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    @Embedded
    val sourceEntity: SourceEntity,
    val title: String?,
    @PrimaryKey
    val url: String,
    val urlToImage: String?,
    val isBookMarked: Boolean = false
)