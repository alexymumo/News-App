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

import androidx.annotation.DrawableRes
import com.alexmumo.presentation.R

sealed class NavItem(val route: String, @DrawableRes var icon: Int?, val title: String) {
    object Home : NavItem("home", R.drawable.ic_home, "Home")
    object Login : NavItem("login", null, "Login")
    object Register : NavItem("register", null, "Register")
    object Bookmark : NavItem("bookmark", R.drawable.ic_bookmark, "BookMark")
    object Search : NavItem("search", R.drawable.ic_search, "Search")
    object Detail : NavItem("detail", null, "detail")
    object Settings : NavItem("settings", R.drawable.ic_settings, "Settings")
}
