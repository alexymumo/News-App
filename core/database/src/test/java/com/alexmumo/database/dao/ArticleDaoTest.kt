package com.alexmumo.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.alexmumo.database.data.articleEntity
import com.alexmumo.database.db.NewsDatabase
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ArticleDaoTest {

    private lateinit var newsDatabase: NewsDatabase
    private lateinit var articleDao: ArticleDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        newsDatabase = Room.inMemoryDatabaseBuilder(
            context,NewsDatabase::class.java
        ).build()

        articleDao = newsDatabase.articleDao()
    }

    @Test
    fun `test save article list`() = runTest {
        val articles = listOf(articleEntity)
        articleDao.saveArticles(articles)
        val result = articleDao.pagingSource()
        Truth.assertThat(result).isEqualTo(articles)
    }

    @Test
    fun `test delete article`() = runTest {
        articleDao.saveArticles(listOf(articleEntity))
        articleDao.deleteArticles()
    }

    @After
    fun close() {
        newsDatabase.close()
    }
}