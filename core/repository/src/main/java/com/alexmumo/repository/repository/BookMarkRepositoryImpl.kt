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
package com.alexmumo.repository.repository

import androidx.lifecycle.LiveData
import com.alexmumo.database.dao.BookMarkDao
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(private val bookMarkDao: BookMarkDao) : BookMarkRepository {
    override suspend fun saveBookMark(bookMarkEntity: BookMarkEntity) {
        return bookMarkDao.saveBookMark(bookMarkEntity)
    }

    override fun getBookMarks(): Flow<List<BookMarkEntity>> {
        return bookMarkDao.getBookMarks()
    }

    override suspend fun deleteBookMark() {
        return bookMarkDao.deleteBookMark()
    }

    override fun checkBookMarked(id: String): LiveData<Boolean> {
        return bookMarkDao.checkBookMarked(id)
    }
}
