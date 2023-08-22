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
package com.alexmumo.presentation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.settings.view.SettingCard
import com.alexmumo.presentation.settings.view.ThemeDialog
import com.alexmumo.presentation.settings.view.settingItem
import org.koin.androidx.compose.getViewModel

@Composable
fun SettingScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel = getViewModel()
) {
    val themeDialog = settingsViewModel.themeDialog.value
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        if (themeDialog) {
            ThemeDialog(
                onDismiss = {
                    settingsViewModel.dialogThemeState(!settingsViewModel.themeDialog.value)
                }, onSelected = {
                settingsViewModel.setTheme(it)
            }
            )
        }

        SettingContent(
            paddingValues = paddingValues,
            onChangeTheme = {
                settingsViewModel.dialogThemeState(!settingsViewModel.themeDialog.value)
            },
            isDisplayed = true
        )
    }
}

@Composable
private fun SettingContent(
    paddingValues: PaddingValues,
    onChangeTheme: () -> Unit,
    isDisplayed: Boolean
) {
    LazyColumn(
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val items = if (isDisplayed) {
            settingItem.filter { it.title != "LAnguage" }
        } else {
            settingItem
        }
        items(items) { items ->
            SettingCard(title = items.title, icon = items.icon, onClick = { options ->
                when (options) {
                    "Change Theme" -> {
                        onChangeTheme()
                    }
                    "Language" -> {
                    }
                    "Share App" -> {
                    }
                }
            })
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    SettingScreen(navController = navController)
}

@Preview
@Composable
fun SettingsItemPreview() {
    // SettingsItem()
}
