package com.alexmumo.presentation.bookmarks

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.repository.BookMarkRepository
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class BookMarkScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    private val bookMarkRepository = mockk<BookMarkRepository>(relaxed = true)
    private val viewModel = BookMarkViewModel(bookMarkRepository = bookMarkRepository)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test bookmark screen`() {
        composeRule.setContent {
            BookMarkScreen(navController = rememberNavController(), viewModel = viewModel)
        }
        composeRule.onNodeWithTag("top_app_bar_test_tag").assertExists()
        composeRule.onNodeWithTag("bookmark_test_tag").assertExists()
    }
}