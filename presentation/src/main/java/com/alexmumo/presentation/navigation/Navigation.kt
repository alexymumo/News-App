/*
 * Copyright 2023 News-App
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            val news = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("news")
            news?.let {
                SearchScreen(navController = navController, article = news)
            }
        }

        composable(NavItem.Settings.route) {
            SettingScreen(navController = navController)
        }
    }
}
