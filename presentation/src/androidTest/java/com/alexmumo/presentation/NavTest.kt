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
package com.alexmumo.presentation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.alexmumo.presentation.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavTest {

    @get:Rule
    val composeRule = createComposeRule()
    private lateinit var navHostController: TestNavHostController

    @Before
    fun setup() {
        composeRule.setContent {
            navHostController = TestNavHostController(LocalContext.current)
            navHostController.navigatorProvider.addNavigator(ComposeNavigator())
            Navigation(navController = navHostController)
        }
    }

    @Test
    fun verify_start_destination_is_home() {
        composeRule
            .onNodeWithText("home")
            .assertIsDisplayed()
    }
}