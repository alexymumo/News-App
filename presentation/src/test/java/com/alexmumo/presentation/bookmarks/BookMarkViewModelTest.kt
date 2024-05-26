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
package com.alexmumo.presentation.bookmarks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import com.alexmumo.domain.repository.BookMarkRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BookMarkViewModelTest {
    private val bookMarkRepository = mockk<BookMarkRepository>(relaxed = true)
    private lateinit var bookMarkViewModel: BookMarkViewModel

    @Before
    fun setUp() {
        bookMarkViewModel = BookMarkViewModel(bookMarkRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test saveBookMark returns success`() = runTest {
        coEvery { bookMarkRepository.getBookMarks() } returns flowOf(listOf(bookMark))
        bookMarkViewModel.saveBookMark(bookMark)
        coVerify { bookMarkViewModel.saveBookMark(bookMark) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test delete returns success`() = runTest {
        bookMarkViewModel.deleteBookMarkedNews()
        coVerify { bookMarkViewModel.deleteBookMarkedNews() }
    }

    @Test
    fun `test checkBookMarked returns true`() = runTest {
        val bookMarkId = "1"
        val liveData = MutableLiveData<Boolean>()
        coEvery { bookMarkViewModel.checkBookMarked(id = "1") } returns liveData
        val expectedValue = bookMarkViewModel.checkBookMarked(id = bookMarkId)
        expectedValue.observeForever { value ->
            Assert.assertEquals(expectedValue, value)
        }
    }

    companion object {
        val bookMark = BookMarkEntity(
            author = null, content = null, description = null, publishedAt = null, SourceEntity(id = null, name = ""), title = null, url = "", urlToImage = null
        )
    }
}
