/*
 * Copyright 2024 News-App
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
package com.alexmumo.database.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alexmumo.database.dao.ArticleDao
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.dao.RemoteKeyDao
import com.alexmumo.database.entity.ArticleEntity
import com.alexmumo.database.entity.SourceEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsDatabaseTest {

    private lateinit var articleDao: ArticleDao
    private lateinit var bookMarkDao: BookMarkDao
    private lateinit var remoteKeyDao: RemoteKeyDao
    private lateinit var newsDatabase: NewsDatabase

    @Before
    fun setUpDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        newsDatabase = Room.inMemoryDatabaseBuilder(
            context,
            NewsDatabase::class.java
        ).build()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveArticles_returns_a_listOf_articles() = runTest {
    }

    @After
    fun closeDatabase() {
        newsDatabase.close()
    }

    companion object {
        private val article = ArticleEntity(author = null, content = null, description = null, publishedAt = null, title = null, SourceEntity(id = null, name = ""), url = "", urlToImage = null)
        val articles = listOf(article)
    }
}
