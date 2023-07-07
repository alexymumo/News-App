package com.alexmumo.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.alexmumo.database.data.bookMarkEntity
import com.alexmumo.database.db.NewsDatabase
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import java.util.concurrent.CountDownLatch
import kotlin.jvm.Throws


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class BookMarkDaoTest {

    private lateinit var newsDatabase: NewsDatabase
    private lateinit var bookMarkDao: BookMarkDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        newsDatabase = Room.inMemoryDatabaseBuilder(
            context,
            NewsDatabase::class.java
        ).build()
        bookMarkDao = newsDatabase.bookMarkDao()
    }

    fun `test save bookmark`() = runBlocking {
        bookMarkDao.saveBookMark(bookMarkEntity)
        val bookmarks = bookMarkDao.getBookMarks()
        Truth.assertThat(bookmarks).isEqualTo(bookmarks)
    }


    fun `test bookmarkdao fetches bookmark list`() = runTest {
        bookMarkDao.getBookMarks()
    }

    fun `test delete bookmark`() {
        runBlocking {
            bookMarkDao.saveBookMark(bookMarkEntity)
            bookMarkDao.deleteBookMark()
            val result = bookMarkDao.getBookMarks()
            Truth.assertThat(result).isNull()
        }
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        newsDatabase.close()
    }
}