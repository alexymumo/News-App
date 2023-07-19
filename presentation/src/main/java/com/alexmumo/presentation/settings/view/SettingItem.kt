package com.alexmumo.presentation.settings.view

import com.alexmumo.presentation.R
import com.alexmumo.presentation.navigation.NavItem

data class SettingItem(
    val title: String,
    val icon: Int
)

val settings = listOf(
    SettingItem(
        title ="Theme",
        icon = R.drawable.ic_theme
    ),
    SettingItem(
        title = "",
        icon = R.drawable.ic_search
    )
)