package com.alexmumo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.presentation.bookmarks.BookMarkScreen
import com.alexmumo.presentation.home.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route
    ) {
        composable(NavItem.Home.route) {
            HomeScreen(
                onNavigate = {
                    navController.navigate("bookmark")
                }
            )
        }

        composable(NavItem.Bookmark.route) {
            BookMarkScreen()
        }

        composable(NavItem.Detail.route) {

        }
    }
}