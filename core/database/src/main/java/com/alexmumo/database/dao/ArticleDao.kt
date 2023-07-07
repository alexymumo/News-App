package com.alexmumo.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexmumo.database.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArticles(article: List<ArticleEntity>)

    @Query("SELECT * FROM article_table")
    fun pagingSource(): PagingSource<Int, ArticleEntity>

    @Query("DELETE FROM article_table")
    suspend fun deleteArticles()
}