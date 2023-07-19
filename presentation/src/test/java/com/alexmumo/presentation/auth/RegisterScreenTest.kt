package com.alexmumo.presentation.auth

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class RegisterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        ShadowLog.stream = System.out
    }


    @Test
    fun `test home screen is displayed`() {
        composeTestRule.setContent {
            RegisterScreen()
        }
        composeTestRule.onNodeWithTag("register_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("register_tag").assertExists()
    }

}