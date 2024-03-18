package com.alexmumo.presentation.bookmarks.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class BookMarkItemTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test bookmark item card`() {
        composeRule.setContent {
            BookMarkCard(bookMarkEntity = bookMarkEntity)
        }
        composeRule.onNodeWithTag("book_mark_card_tag").assertExists()
        composeRule.onNodeWithContentDescription("image").assertExists()
        composeRule.onNodeWithTag("divider_tag").assertExists()
    }

    companion object{
        val bookMarkEntity = BookMarkEntity(author = null, content = null,description = null,publishedAt = null,
            SourceEntity(id = null, name = ""), title = null, url = "", urlToImage = null, isBookMarked = false
        )
    }
}