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
package com.alexmumo.presentation.home

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.repository.NewsRepository
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class HomeScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val newsRepository = mockk<NewsRepository>(relaxed = true)
    private val viewModel = HomeViewModel(newsRepository = newsRepository)
    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test home screen`() {
        composeRule.setContent {
            HomeScreen(navController = rememberNavController(), viewModel = viewModel)
        }
        composeRule.onNodeWithTag("title_test_tag").assertExists()
        composeRule.onNodeWithTag("share_fab_test_tag").assertExists()
        composeRule.onNodeWithTag("home_test_tag").assertExists()
    }
}
