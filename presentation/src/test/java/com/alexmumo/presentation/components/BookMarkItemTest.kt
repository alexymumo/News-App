package com.alexmumo.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.testing.TestNavHostController
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.database.entity.SourceEntity
import com.alexmumo.presentation.bookmarks.components.BookMarkItem
import com.alexmumo.presentation.data.bookMark
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.RobolectricTestRunner
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowLog
import kotlin.jvm.Throws

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
    fun `test book mark item is displayed`() {
        composeRule.setContent {
            BookMarkItem(bookMarkEntity = bookMark)
        }
        composeRule.onNodeWithTag("bookmark_tag").assertIsDisplayed()
        composeRule.onNodeWithTag("bookmark_tag").assertExists()
    }
}

