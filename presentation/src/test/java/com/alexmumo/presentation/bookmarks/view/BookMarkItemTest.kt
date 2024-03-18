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
package com.alexmumo.presentation.bookmarks.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class BookMarkItemTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test bookmark item card`() {
        composeRule.setContent {
            BookMarkCard(bookMarkEntity = bookMarkEntity)
        }
        composeRule.onNodeWithTag("book_mark_card_tag").assertExists()
        composeRule.onNodeWithContentDescription("image").assertExists()
        composeRule.onNodeWithTag("divider_tag").assertExists()
    }

    companion object {
        val bookMarkEntity = BookMarkEntity(
            author = null, content = null, description = null, publishedAt = null,
            SourceEntity(id = null, name = ""), title = null, url = "", urlToImage = null, isBookMarked = false
        )
    }
}
