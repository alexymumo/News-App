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
package com.alexmumo.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source
import org.junit.Rule
import org.junit.Test

class NewsCardKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testNewsCardIsDisplayed() {
        composeRule.setContent {
            NewsCard(onNavigate = {}, article = article)
        }
        composeRule.onNodeWithTag("news_card_test_tag").assertExists()
        composeRule.onNodeWithTag("news_card_test_tag").assertIsDisplayed()
    }
}

val source = Source(
    id = null,
    name = ""
)

val article = Article(
    author = null,
    content = null,
    description = null,
    publishedAt = null,
    source = source,
    title = null,
    url = "",
    urlToImage = null
)
