/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            context, NewsDatabase::class.java
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
