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
package com.alexmumo.presentation.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source
import com.alexmumo.domain.repository.BookMarkRepository
import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"], sdk = [33])
class DetailScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    private val bookMarkRepository = mockk<BookMarkRepository>(relaxed = true)
    private val viewModel = BookMarkViewModel(bookMarkRepository = bookMarkRepository)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test detail screen`() {
        composeRule.setContent {
            DetailScreen(navController = rememberNavController(), viewModel = viewModel, article = article)
        }
        composeRule.onNodeWithTag("detail_tag").assertExists()
    }

    @Test
    fun `test custom button`() {
        composeRule.setContent {
            CustomLikeButton(
                onPress = {},
                bookmarked = true
            )
        }
        composeRule.onNodeWithTag("custom_like_tag", useUnmergedTree = true).assertExists()
        // composeRule.onNodeWithTag("custom_like_tag").performClick()
    }

    companion object {
        val article = Article(
            author = null, content = null, description = null, publishedAt = null, Source(id = null, name = ""), title = null, url = "", urlToImage = null
        )
    }
}
