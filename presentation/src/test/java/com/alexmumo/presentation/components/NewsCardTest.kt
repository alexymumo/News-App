package com.alexmumo.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.alexmumo.presentation.data.article
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
class NewsCardTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test news card is displayed`() {
        composeRule.setContent {
            NewsCard(onNavigate = {}, article = article)
        }
        composeRule.onNodeWithTag("news_card_tag").assertIsDisplayed()
        composeRule.onNodeWithTag("news_card_tag").assertExists()
    }
}