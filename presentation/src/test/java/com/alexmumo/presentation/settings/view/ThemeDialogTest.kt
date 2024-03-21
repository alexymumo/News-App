package com.alexmumo.presentation.settings.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ThemeDialogTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun `test theme dialog`() {
        composeRule.setContent {
            ThemeDialog(onDismiss = { /*TODO*/ }, onSelected = {})
        }
        composeRule.onNodeWithTag("alert_dialog_tag")
    }
}