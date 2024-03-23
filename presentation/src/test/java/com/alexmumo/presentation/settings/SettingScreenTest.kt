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
package com.alexmumo.presentation.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.alexmumo.datastore.SettingsRepositoryImpl
import com.alexmumo.domain.repository.SettingRepository
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class SettingScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    private val settingsRepository = mockk<SettingRepository>(relaxed = true)
    private val settingsViewModel = SettingsViewModel(settingRepository = settingsRepository)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test settings screen`() {
        composeRule.setContent {
            SettingScreen(navController = rememberNavController(), settingsViewModel = settingsViewModel)
        }
        composeRule.onNodeWithTag("top_app_bar_tag").assertExists()
        composeRule.onNodeWithTag("setting_screen_test_tag").assertExists()
    }

    @Test
    fun `test settings content`() {
        composeRule.setContent {
            SettingContent(paddingValues = PaddingValues(), onChangeTheme = { /*TODO*/ }, isDisplayed = true)
        }
        composeRule.onNodeWithTag("settings_content_tag").assertExists()
    }
}