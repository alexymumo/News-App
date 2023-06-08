package com.alexmumo.presentation.navigation

import androidx.annotation.DrawableRes
import com.alexmumo.presentation.R

sealed class NavItem(val route: String, @DrawableRes var icon: Int, val title: String) {
    object Home: NavItem("home", R.drawable.ic_android_black_24dp, "test")
    object Bookmark: NavItem("bookmark", R.drawable.ic_android_black_24dp, "test")
    object Detail: NavItem("detail", R.drawable.ic_android_black_24dp, "test")
    object Settings: NavItem("settings", R.drawable.ic_android_black_24dp, "test")
}
