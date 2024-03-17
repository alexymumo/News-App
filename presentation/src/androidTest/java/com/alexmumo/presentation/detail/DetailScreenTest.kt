package com.alexmumo.presentation.detail

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule


class DetailScreenTest {

    @get:Rule
    val composeRule = createComposeRule()


    fun testDetailScreen() {
        composeRule.setContent {
            DetailScreen(navController = , article = )
        }

    }

}