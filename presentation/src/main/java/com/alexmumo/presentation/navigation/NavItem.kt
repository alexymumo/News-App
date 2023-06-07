package com.alexmumo.presentation.navigation

sealed class NavItem(val route: String, val icon: String, val title: String) {
    object Home: NavItem("home", "test", "test")
    object Bookmark: NavItem("bookmark", "test", "test")
    object Detail: NavItem("detail", "test", "test")
}
