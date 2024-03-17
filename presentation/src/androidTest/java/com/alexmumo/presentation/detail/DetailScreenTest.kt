package com.alexmumo.presentation.detail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import com.alexmumo.presentation.data.article
import org.junit.Rule
import org.junit.Test


class DetailScreenTest {

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Test
    fun testDetailScreen() {
        composeRule.setContent {
            DetailScreen(navController = navController, article = article)
        }
        composeRule.onNodeWithTag("detail_tag").assertExists()
        composeRule.onNodeWithTag()
        composeRule.onNodeWithText("Already Bookmarked").assertExists()
        composeRule.onNodeWithTag("detail_screen").assertExists()

    }
}