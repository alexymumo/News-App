package com.alexmumo.presentation.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
class SettingScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(IOException::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `verify setting screen is displayed`() {
        composeRule.setContent {
            //SettingScreen()
        }
        composeRule.onNodeWithTag("setting_tag").assertExists()
        composeRule.onNodeWithTag("setting_tag").assertIsDisplayed()
    }

    @After
    fun close() {

    }
}