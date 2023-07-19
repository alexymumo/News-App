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

/*
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

 */
