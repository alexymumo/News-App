package com.alexmumo.database.dao

import androidx.room.Room
import com.alexmumo.database.db.NewsDatabase
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.CountDownLatch


@RunWith(RobolectricTestRunner::class)
class BookMarkDaoTest {

    private lateinit var newsDatabase: NewsDatabase
    private lateinit var bookMarkDao: BookMarkDao

    val bookMark = BookMarkEntity(
        "alex",
        "test content",
        "this is test news",
        "12-0-2023",
        SourceEntity(
            "id",
            "name test"
        ),
        "Breaking news",
        "news.url",
        "urlToImage",
        false
    )


    @Before
    fun setup() {
        //newsDatabase = Room.inMemoryDatabaseBuilder(
          //  NewsDatabase::class.java
        //)
        bookMarkDao = newsDatabase.bookMarkDao()
    }

    fun `test save bookmark`() = runBlocking {
        bookMarkDao.saveBookMark(bookMark)
        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            bookMarkDao.getBookMarks().collect {

            }
        }
        latch.await()
        job.cancelAndJoin()
    }

    fun `test bookmarkdao fetches bookmark list`() = runBlocking {
        bookMarkDao.getBookMarks()
    }

    @After
    fun teardown() {
        newsDatabase.close()
    }
}