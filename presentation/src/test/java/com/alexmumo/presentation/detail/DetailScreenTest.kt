package com.alexmumo.presentation.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.alexmumo.domain.model.Article
import com.alexmumo.domain.model.Source
import com.alexmumo.domain.repository.BookMarkRepository
import com.alexmumo.presentation.bookmarks.BookMarkViewModel
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"], sdk = [33])
class DetailScreenTest {
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
    fun testDetailLayout() {
        composeRule.setContent {
            DetailScreen(navController = rememberNavController(), viewModel = viewModel, article = Article(author = null, content = null,description = null,publishedAt = null, Source(id = null, name = ""),title = null, url = "", urlToImage = null ))
        }
        composeRule.onNodeWithTag("detail_tag").assertExists()
    }
}