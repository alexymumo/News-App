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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexmumo.presentation.R
import com.alexmumo.presentation.settings.view.SettingCard
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
        val opendialog = remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .testTag("setting_tag")
        ) {
            SettingCard(title = "Change Theme", icon = R.drawable.ic_theme)
            Spacer(modifier = Modifier.height(5.dp))
            SettingCard(title = "Language", icon = R.drawable.language)
            Spacer(modifier = Modifier.height(5.dp))
            SettingCard(title = "Share", icon = R.drawable.ic_arrow)
            Spacer(modifier = Modifier.height(5.dp))
            SettingCard(title = "Source Code", icon = R.drawable.ic_settings)
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


/*
         Card(
             onClick = {
                 opendialog.value =  true
             },
             modifier = Modifier
                 .fillMaxWidth()
                 .height(40.dp)
                 .padding(all = 5.dp)
         ) {
             Row(
                 horizontalArrangement = Arrangement.spacedBy(10.dp),
                 verticalAlignment = Alignment.CenterVertically
             ) {
                 Icon(painter = painterResource(id = R.drawable.ic_theme), contentDescription = null)
                 Text(text = "Change Theme")
                 Icon(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = null)
             }
             if (opendialog.value) {
                 CustomDialog(onDismiss = {
                     settingsViewModel.dialogThemeState(settingsViewModel.themeDialog.value)
                 }, onSelected = {
                     settingsViewModel.setTheme(it)
                 })
             }
         }
         */