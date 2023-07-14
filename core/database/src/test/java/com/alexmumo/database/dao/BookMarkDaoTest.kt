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
