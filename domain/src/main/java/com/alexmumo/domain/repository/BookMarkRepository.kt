package com.alexmumo.domain.repository

import com.alexmumo.database.entity.BookMarkEntity
import kotlinx.coroutines.flow.Flow

interface BookMarkRepository {
    fun getBookMarks(): Flow<List<BookMarkEntity>>
    suspend fun saveBookMark(bookMarkEntity: BookMarkEntity)
    suspend fun deleteBookMark()
}