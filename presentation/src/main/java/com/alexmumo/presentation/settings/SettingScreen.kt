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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.settings.view.SettingCard
import com.alexmumo.presentation.settings.view.ThemeDialog
import com.alexmumo.presentation.settings.view.settingItem

@Composable
fun SettingScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val themeDialog = settingsViewModel.themeDialog.value
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.testTag("top_app_bar_tag"),
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
        modifier = Modifier
            .fillMaxSize()
            .testTag("setting_screen_test_tag")
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
fun SettingContent(
    paddingValues: PaddingValues,
    onChangeTheme: () -> Unit,
    isDisplayed: Boolean
) {
    LazyColumn(
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.testTag("settings_content_tag")
    ) {
        val items = if (isDisplayed) {
            settingItem.filter { it.title != "Language" }
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

@Composable
fun Settings() {
    Column(modifier = Modifier.fillMaxSize()) {

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(all = 4.dp),
            shape = CardDefaults.outlinedShape
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Sign In")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Sign Up")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(all = 5.dp),
            border = BorderStroke(width = 1.dp, brush = Brush.linearGradient()),
            shape = CardDefaults.outlinedShape
        ) {
            Text(text = "Change Theme")
            Divider(modifier = Modifier.fillMaxWidth())
            Text(text = "Share App")
            Divider(modifier = Modifier
                .fillMaxWidth()
                .width(0.5.dp))
            Text(text = "Language")
            Divider(modifier = Modifier
                .fillMaxWidth()
                .width(0.5.dp))
            Text(text = "About Us")

        }
    }
}
@Preview
@Composable
fun SettingsScreenPreview() {
    Settings()
    //val navController = rememberNavController()
    //SettingScreen(navController = navController)
}

@Preview
@Composable
fun SettingsItemPreview() {
    // SettingsItem()
}
