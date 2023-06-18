package com.alexmumo.presentation.navigation

import androidx.annotation.DrawableRes
import com.alexmumo.presentation.R

sealed class NavItem(val route: String, @DrawableRes var icon: Int?, val title: String) {
    object Home: NavItem("home", R.drawable.ic_home,"Home")
    object Search: NavItem("search", R.drawable.ic_search, "Search")
    object Bookmark: NavItem("bookmark", R.drawable.ic_bookmark, "Bookmark")
    object Detail: NavItem("detail", null, "Detail")
    object Settings: NavItem("settings", R.drawable.ic_settings, "Settings")

}
