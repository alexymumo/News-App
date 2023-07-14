package com.alexmumo.repository.repository

import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow

class BookMarkRepositoryImpl constructor(private val bookMarkDao: BookMarkDao) : BookMarkRepository {
    override suspend fun saveBookMark(bookMarkEntity: BookMarkEntity) {
        return bookMarkDao.saveBookMark(bookMarkEntity)
    }

    override fun getBookMarks(): Flow<List<BookMarkEntity>> {
        return bookMarkDao.getBookMarks()
    }

    override suspend fun deleteBookMark() {
        return bookMarkDao.deleteBookMark()
    }
}
