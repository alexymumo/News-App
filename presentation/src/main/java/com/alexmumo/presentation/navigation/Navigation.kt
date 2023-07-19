package com.alexmumo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.domain.model.Article
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
            HomeScreen(navController = navController)
        }
        composable(NavItem.Bookmark.route) {
            BookMarkScreen(navController = navController)
        }

        composable(NavItem.Detail.route) {
            val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("news")
            article?.let {
                DetailScreen(navController = navController, article = article)
            }
        }
        composable(NavItem.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(NavItem.Settings.route) {
            SettingScreen(navController = navController)
        }
    }
}
