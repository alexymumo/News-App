package com.alexmumo.presentation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.alexmumo.presentation.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavTest {

    @get:Rule
    val composeRule = createComposeRule()
    private lateinit var navHostController: TestNavHostController

    @Before
    fun setup() {
        composeRule.setContent {
            navHostController = TestNavHostController(LocalContext.current)
            navHostController.navigatorProvider.addNavigator(ComposeNavigator())
            Navigation(navController = navHostController)
        }
    }

    @Test
    fun verify_start_destination_is_home() {
        composeRule
            .onNodeWithText("home")
            .assertIsDisplayed()
    }
}
