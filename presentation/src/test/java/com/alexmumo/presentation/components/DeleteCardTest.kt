package com.alexmumo.presentation.components

import androidx.compose.material3.rememberDismissState
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class DeleteCardTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp(){
        ShadowLog.stream = System.out
    }

    @Test
    fun `test delete card`() {
        composeRule.setContent {
            DeleteCard(dismissState = rememberDismissState())
        }
        composeRule.onNodeWithTag("delete_card_tag").assertExists()
    }
}