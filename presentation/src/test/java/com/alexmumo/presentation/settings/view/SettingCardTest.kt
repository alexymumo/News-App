package com.alexmumo.presentation.settings.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import com.alexmumo.presentation.R

@RunWith(RobolectricTestRunner::class)
class SettingCardTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test setting card is displayed`() {
        composeRule.setContent {
            SettingCard(onClick = {}, title = "settings", icon = R.drawable.ic_theme)
        }
        composeRule.onNodeWithTag("settings_tag").assertIsDisplayed()
        composeRule.onNodeWithTag("settings_tag").assertExists()

    }
}