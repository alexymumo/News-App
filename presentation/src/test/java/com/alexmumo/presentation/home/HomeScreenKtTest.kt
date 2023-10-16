package com.alexmumo.presentation.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.testing.TestNavHostController
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
class HomeScreenKtTest {


    @get:Rule
    val composeRule = createComposeRule()
    private lateinit var navigationTestNavHostController: TestNavHostController


    @Before
    @Throws(Exception::class)
    fun setup() {
        ShadowLog.stream = System.out
    }


    @Test
    fun `test home screen is displayed`() {
        composeRule.setContent {
            HomeScreen(navController = navigationTestNavHostController)
        }
        composeRule.onNodeWithTag("home_test").assertIsDisplayed()
        composeRule.onNodeWithTag("home_test").assertExists()
    }
}