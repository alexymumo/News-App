package com.alexmumo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.presentation.bookmarks.BookMarkScreen
import com.alexmumo.presentation.detail.DetailScreen
import com.alexmumo.presentation.home.HomeScreen
import com.alexmumo.presentation.search.SearchScreen
import com.alexmumo.presentation.settings.SettingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route
    ) {
        composable(NavItem.Home.route) {
            HomeScreen(
                onNavigate = {
                    //navController.navigate("detail")
                },
                navController = navController
            )
        }
        composable(NavItem.Bookmark.route) {
            BookMarkScreen()
        }

        composable(NavItem.Detail.route) {
            DetailScreen()
        }

        composable(NavItem.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(NavItem.Settings.route) {
            SettingScreen(navController = navController)
        }
    }
}