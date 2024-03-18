package com.alexmumo.presentation.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


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
    fun `test news card`() {
        composeRule.setContent {
            NewsCard(onNavigate = {}, article = article)
        }
        composeRule.onNodeWithTag("news_card_test_tag",useUnmergedTree = true).assertExists()
    }

    companion object{
        val article = Article(
            author = null, content = null, description = null, publishedAt = null, Source(id = null, name = ""), title = null, url = "", urlToImage = null
        )
    }
}